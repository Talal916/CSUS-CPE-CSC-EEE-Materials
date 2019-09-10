package com.mycompany.a3;

import java.util.Random;

public class RandomClass {

	
		public static int getRandInt(int min, int max)
		{
			Random num = new Random();
			int retval = num.nextInt((max - min)+1)+min;
			return retval;
		}
}
