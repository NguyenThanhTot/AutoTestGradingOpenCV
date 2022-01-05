package com.test.grading;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

public class GetResltExamFrame {

	public static final double X_DAP_AN_PERCENT = 0.0227;
	public static final double Y_DAP_AN_PERCENT = 0.4755;
	public static final double W_DAP_AN_PERCENT = 0.9704;
	public static final double H_DAP_AN_PERCENT = 0.5245;

	public Mat getResultFrame(Mat src) {
		int x = (int) (X_DAP_AN_PERCENT * src.cols());
		int y = (int) (Y_DAP_AN_PERCENT * src.rows());
		int w = (int) (W_DAP_AN_PERCENT * src.cols());
		int h = (int) (H_DAP_AN_PERCENT * src.rows());
		Mat result = new Mat(src, new Rect(x + 50, y - 10, w - 100, h + 10));
		return result;
	}

}
