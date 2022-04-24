package testdata;

import java.util.Random;

public class TestData {
	
	public static String Name = "new_product";	
	public static double quantity = 20.0;
	
	public static long getRandomNum() {
		long randomNum = new Random().nextInt(10000000);
		return randomNum;
	}
	
	public static String productName = Name + "_" + getRandomNum();

}
