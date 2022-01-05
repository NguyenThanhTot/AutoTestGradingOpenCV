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


	public static void main(String[] args) {
		
		
		Mat testID = new Mat();
		Mat stdID = new Mat();
		Mat answers = new Mat();
		

		String filePath = "src/dapan4.jpg";
		Mat src = Imgcodecs.imread(filePath);

		GetAnswers getAns = new GetAnswers();
	
		Map<Integer, Line> ok = getAns.getAnswers(answers);

	}

}
