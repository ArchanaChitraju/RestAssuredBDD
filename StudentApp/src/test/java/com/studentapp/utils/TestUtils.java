package com.studentapp.utils;

import java.util.Random;

public class TestUtils {
	
	public static String randomvalue() {
		Random random = new Random();
		int randomlist=random.nextInt(100000);
		return Integer.toString(randomlist);
	}

}
