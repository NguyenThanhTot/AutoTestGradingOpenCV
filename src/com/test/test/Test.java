package com.test.test;

import java.util.Map;
import java.util.Map.Entry;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import com.phase.GetFrame;
import com.test.grading.GetBiggestFrame;
import com.test.model.Line;
import com.test.model.Paper;
import com.test.process.Plantain_StudentID;

public class Test {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat testID = new Mat();
		Mat stdID = new Mat();
		Mat answers = new Mat();

		String filePath = "src/dapan4.jpg";
		Mat src = Imgcodecs.imread(filePath);

		GetAnswers getAns = new GetAnswers();

		Map<Integer, Line> ok = getAns.getAnswers(answers);
		String filePath1 = "src/img/img-mssv/rs-ma-so-sv-1.jpg";
		Mat stuSrc = Imgcodecs.imread(filePath1);
		Plantain_StudentID stu = new Plantain_StudentID(stuSrc, true);
		String MSSV = stu.getCodeID();
		String filePath2 = "src/img/rs-ma-de-11.jpg";
		Mat planSrc = Imgcodecs.imread(filePath2);
		Plantain_StudentID plan = new Plantain_StudentID(planSrc, false);
		String MaDe =plan.getCodeID();
		
		
		
		
		String filePath = "src/img/1.jpg";
		Mat src = Imgcodecs.imread(filePath);

		Mat idExam = new Mat();
		Mat idStudent = new Mat();
		Mat resultExam = new Mat();

		GetFrame getFrame = new GetFrame();
		getFrame.execute(src, idExam, idStudent, resultExam);
	}

}
