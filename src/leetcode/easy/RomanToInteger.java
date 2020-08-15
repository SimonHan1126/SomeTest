package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	// Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）

	public int romanToInt(String romanNumeral) {
		
		Map<Character, Integer> mapRoman2Integer = new HashMap<>();
		mapRoman2Integer.put('I', 1);
		mapRoman2Integer.put('V', 5);
		mapRoman2Integer.put('X', 10);
		mapRoman2Integer.put('L', 50);
		mapRoman2Integer.put('C', 100);
		mapRoman2Integer.put('D', 500);
		mapRoman2Integer.put('M', 1000);
		
		int intFromRoman = 0;
		if(romanNumeral == null || romanNumeral.length() <= 0)
		{
			System.out.println("1111111111");
			return 0;
		}
		
		boolean isFistContinuous = false;
		int romanNumeralLength = romanNumeral.length();
		for(int i = 0; i < romanNumeralLength; i++)
		{
			char itemCharacter = romanNumeral.charAt(i);
			if(!mapRoman2Integer.containsKey(itemCharacter))
			{
				System.out.println("222222222 " + itemCharacter);
				return 0;
			}
			int itemInteger = mapRoman2Integer.get(itemCharacter);
			char nextCharacter = 'A';
			if(i < (romanNumeralLength - 1))
			{
				nextCharacter = romanNumeral.charAt(i + 1);
			}
			 
			int nextInteger = 0;
			if(mapRoman2Integer.containsKey(nextCharacter))
			{
				nextInteger = mapRoman2Integer.get(nextCharacter);
			}
			
			if(itemInteger == nextInteger)
			{
				if(isFistContinuous)
				{
					isFistContinuous = true;
					itemInteger = 0 - itemInteger;
				}
				else
				{
					isFistContinuous = false;
				}
			}
			
			if(itemInteger < nextInteger)
			{
				itemInteger = 0 - itemInteger;
			}
			
			System.out.println("itemInteger " + itemInteger);
			
			intFromRoman += itemInteger;
			if(intFromRoman > 3999)
			{
				System.out.println("3333333333");
				return 0;
			}
		}
		return intFromRoman;
	}

	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		int intFromRoman = rti.romanToInt("IIM");
		System.out.println(intFromRoman);
	}
}
