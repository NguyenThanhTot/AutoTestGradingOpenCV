package com.test.test;

import java.util.Map;
import java.util.Map.Entry;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import com.test.grading.GetBiggestFrame;
import com.test.model.Line;
import com.test.model.Paper;
import com.test.process.Plantain_StudentID;

public class Test {

	String filePath = "src/dapan3.jpg";
	public Paper paper = new Paper();
	public GetBiggestFrame getBiggestFrame = new GetBiggestFrame();

	public void Run(String filePath) {
		System.out.println("\nHình: ");
		Mat src = Imgcodecs.imread(filePath);
		Mat get_Area = paper.getRectIn4Rect(src);
		Imgcodecs.imwrite("src/img/getRectIn4Rect.jpg", get_Area);
		Imgcodecs.imwrite("src/img/rs-dap-an.jpg", getBiggestFrame.getResultFrame(get_Area));
		Imgcodecs.imwrite("src/img/rs-ma-so-sv.jpg", getBiggestFrame.getIDStudentFrame(get_Area));
		Imgcodecs.imwrite("src/img/rs-ma-de.jpg", getBiggestFrame.getIDExameFrame(get_Area));
		Imgcodecs.imwrite("src/img/rs-ten-sv.jpg", getBiggestFrame.getNameFrame(get_Area));
	}

	public void RunMutiple(int serial) {

		for (int i = 1; i <= serial; i++) {

			String imgSerial = "\nHình: " + i;
			String filePath = "src/img/" + i + ".jpg";
			String getRectIn4Rect = "src/img/getRectIn4Rect-" + i + ".jpg";
			String dapAn = "src/img/rs-dap-an-" + i + ".jpg";
			String maSoSv = "src/img/rs-ma-so-sv-" + i + ".jpg";
			String maDe = "src/img/rs-ma-de-" + i + ".jpg";
			String tenSv = "src/img/rs-ten-sv-" + i + ".jpg";

			System.out.println(imgSerial);
			Mat src = Imgcodecs.imread(filePath);
			Mat get_Area = paper.getRectIn4Rect(src);
			Imgcodecs.imwrite(getRectIn4Rect, get_Area);
			Imgcodecs.imwrite(dapAn, getBiggestFrame.getResultFrame(get_Area));
			Imgcodecs.imwrite(maSoSv, getBiggestFrame.getIDStudentFrame(get_Area));
			Imgcodecs.imwrite(maDe, getBiggestFrame.getIDExameFrame(get_Area));
			Imgcodecs.imwrite(tenSv, getBiggestFrame.getNameFrame(get_Area));
		}
	}

	public static void print(Map<Integer, Line> ok) {
		for (Entry<Integer, Line> en : ok.entrySet()) {
			System.out.println(en.getKey() + "  " + en.getValue().getValue());
		}
	}

	// test mã đề và MSSV
	public void runPlantain_StuID() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String s10 = "./src/img/rs-ma-de-4.jpg";
		Mat m10 = Imgcodecs.imread(s10);
		for (int i = 1; i <= 46; i++) {
			if (i != 5 && i != 31 && i != 35) {
				String s11 = "./src/img/img-mssv/rs-ma-so-sv-" + String.valueOf(i) + ".jpg";
				Mat m11 = Imgcodecs.imread(s11);
				Plantain_StudentID oStu3 = new Plantain_StudentID(m11, true);
//		Imgcodecs.imwrite("./src/img/grayStu.jpg", oStu.imgGray());
//		Imgcodecs.imwrite("./src/img/thresholdStu.jpg", oStu.threshold());
//		Imgcodecs.imwrite("./src/img/stuID.jpg", oStu.imgPlan_StuID(oStu.threshold()));
				System.out.println(i + "MSSV : " + oStu3.getCodeID());
			} else {
				continue;
			}

		}
		Plantain_StudentID oPlan = new Plantain_StudentID(m10, false);
//	Imgcodecs.imwrite("./src/img/grayPlan.jpg", oPlan.imgGray());
//	Imgcodecs.imwrite("./src/img/thresholdPlan.jpg", oPlan.threshold());
//	Imgcodecs.imwrite("./src/img/plantain.jpg", oPlan.imgPlan_StuID(oPlan.threshold()));
		System.out.println("Mã Đề : " + oPlan.getCodeID());
		// 5,3,8,10,14,19,23,27,32,34,35,37,38
		
	}

	public static void main(String[] args) {
//
		Test test = new Test();
//		test.RunMutiple(20);
		test.runPlantain_StuID();

//		String filePath = "src/dapan4.jpg";
//
//		GetAnswers getAns = new GetAnswers();
//		Mat src = Imgcodecs.imread(filePath);
//		Map<Integer, Line> ok = getAns.getAnswers(src);
//
//		print(ok);

	}

}
