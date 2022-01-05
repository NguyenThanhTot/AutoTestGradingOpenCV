package com.test.grading;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class GetIdStudentFrame {

	public static final double X_ID_STUDENT_PERCENT = 0.55;
	public static final double Y_ID_STUDENT_PERCENT = 0.005;
	public static final double W_ID_STUDENT_PERCENT = 0.4;
	public static final double H_ID_STUDENT_PERCENT = 0.3;

	public Mat getIDStudentFrame(Mat start) {
		int x = (int) (X_ID_STUDENT_PERCENT * start.cols());
		int y = (int) (Y_ID_STUDENT_PERCENT * start.rows());
		int w = (int) (W_ID_STUDENT_PERCENT * start.cols());
		int h = (int) (H_ID_STUDENT_PERCENT * start.rows());
		Mat res = new Mat(start, new Rect(x, y, w, h));
		Imgcodecs.imwrite("src/img/res.jpg", res);
		Mat newSize = new Mat();
		Imgproc.resize(res, newSize, new Size(res.width(), res.height()));
		System.out.println("res.width()" + newSize.width());
		System.out.println("res.height()" + newSize.height());
		Mat gray = MatProcess2.toColorGray(newSize);
		Mat thresh_image = MatProcess2.toThreshBinary(gray, 100);
		Imgcodecs.imwrite("src/img/thresh_image.jpg", thresh_image);
		List<MatOfPoint> contours = MatProcess2.getContour(thresh_image);
		Set<Rect> rects = new TreeSet<Rect>(RectCompare.RECT_COMPARE);
		for (int i = 0; i < contours.size(); i++) {
			Rect rect = Imgproc.boundingRect(contours.get(i));
			if (rect.area() > 50 && rect.area() < 250 && rect.x < thresh_image.cols() / 6
					&& rect.y < thresh_image.rows() / 6) {
				rects.add(rect);
			}
		}
		ArrayList<Rect> list = new ArrayList<Rect>();
		for (Rect r : rects) {
			list.add(r);
		}
		System.out.println("list: " + list);
		int x_drop = ((list.get(0).x) - 10 < 0) ? 0 : (list.get(0).x) - 10;
		int y_drop = ((list.get(0).y) - 10 < 0) ? 0 : (list.get(0).y) - 10;
		System.out.println("x_drop: " + x_drop);
		System.out.println("y_drop: " + y_drop);

		int w_drop_temp = list.get(0).width * 13;
		int w_drop = ((w_drop_temp + x_drop) > res.width()) ? res.width() - x_drop : w_drop_temp;

		int h_drop_temp = list.get(0).height * 23;
		System.out.println("h_drop_temp: " + h_drop_temp);
		int h_drop = ((h_drop_temp + y_drop) > res.height()) ? res.height() - y_drop : h_drop_temp;

		System.out.println("w_drop: " + w_drop);
		System.out.println("h_drop: " + h_drop);
		Mat drop_Mat = new Mat(newSize, new Rect(x_drop, y_drop, w_drop, h_drop));
		Mat result_last = new Mat();
		Imgproc.resize(drop_Mat, result_last, new Size(start.width() / 2, start.height() / 2));
		return result_last;
	}

}
