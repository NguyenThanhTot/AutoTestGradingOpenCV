package com.test.grading;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class GetFrame {

	Paper paper = new Paper();
	GetIdExamFrame getIdExamFrame = new GetIdExamFrame();
	GetResltExamFrame getResltExamFrame = new GetResltExamFrame();
	GetIdStudentFrame getIdStudentFrame = new GetIdStudentFrame();

	public void execute(Mat src, Mat idExam, Mat idStudent, Mat resultExam) {
		Mat get_Area = paper.getRectIn4Rect(src);

		idExam = getIdExamFrame.getIDExameFrame(get_Area);
		idStudent = getIdStudentFrame.getIDStudentFrame(get_Area);
		resultExam = getResltExamFrame.getResultFrame(get_Area);

		String dapAn = "src/img/rs-dap-an-" + ".jpg";
		String maSoSv = "src/img/rs-ma-so-sv-" + ".jpg";
		String maDe = "src/img/rs-ma-de-" + ".jpg";

		Imgcodecs.imwrite(dapAn, resultExam);
		Imgcodecs.imwrite(maSoSv, idStudent);
		Imgcodecs.imwrite(maDe, idExam);
	}

}
