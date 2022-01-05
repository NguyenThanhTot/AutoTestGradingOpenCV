package com.test.process;

import java.util.Comparator;

import org.opencv.core.Rect;

public class RectCompare {

	public static final Comparator<Rect> RECT_COMPARE = new Comparator<Rect>() {

		@Override
		public int compare(Rect o1, Rect o2) {
//			if (Math.abs(o1.x - o2.x) <= 50 && Math.abs(o1.y - o2.y) <= 50) // lọc nhiễu
			if (Math.abs(o1.x - o2.x) <= 100 && Math.abs(o1.y - o2.y) <= 100) // lọc nhiễu
				return 0;
			else if (Math.abs(o1.x - o2.x) <= 100) // cùng 1 cột sắp xếp theo y
				if (o1.y > o2.y)
					return 1;
				else
					return -1;
			else
				return Integer.compare(o1.x, o2.x); // khác cột sắp xếp theo x
		}

	};

}
