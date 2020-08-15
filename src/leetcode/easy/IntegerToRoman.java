package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

	public String intToRoman(int num) {

		if (num < 1 || num > 3999) {
			return "";
		}

		String resultStr = "";
		int index = 0;
		while (index < 4) {
			int newResult = num % 10;
			num = num / 10;
			
			String one = "I";
			String five = "V";
			String ten = "X";
			switch (index) {
			case 1:
				one = "X";
				five = "L";
				ten = "C";
				break;
			case 2:
				one = "C";
				five = "D";
				ten = "M";
				break;
			case 3:
				one = "M";
				break;
			}
			
			if(newResult == 9)
			{
				resultStr = ten + resultStr;
				resultStr = one + resultStr;
			}
			else if(newResult < 9 && newResult > 5)
			{
				for(int i = 5; i < newResult; i++)
				{
					resultStr = one + resultStr;
				}
				resultStr = five + resultStr;
			}
			else if(newResult == 5)
			{
				resultStr = five + resultStr;
			}
			else if(newResult == 4)
			{
				resultStr = five + resultStr;
				resultStr = one + resultStr;
			}
			else if(newResult < 4)
			{
				for(int i = 0; i < newResult; i++)
				{
					resultStr = one + resultStr;
				}
			}

			index++;
		}

		return resultStr;
	}

	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(998));
		
//		String resultStr = "";
//		for(int i = 0; i < 10; i++)
//		{
//			resultStr = i + resultStr;
//		}
//		System.out.println(resultStr);
	}
}
