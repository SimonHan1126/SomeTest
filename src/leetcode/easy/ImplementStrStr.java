package leetcode.easy;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		int needleLength = needle.length();
		int haystackLength = haystack.length();
		if (haystackLength <= 0 && needleLength <= 0) return 0;
		if (needleLength <= 0) return 0;
		if (needleLength > haystackLength) return -1;
		char haystackArray[] = haystack.toCharArray();
		char needleArray[] = needle.toCharArray();

		int haystackIndex = 0;
		int resultIndex = -1;
		boolean isFindWholeNeedle = false;
		while (haystackIndex < haystackLength)
		{
			if(needleArray[0] != haystackArray[haystackIndex])
			{
				haystackIndex++;
				continue;
			}
			resultIndex = haystackIndex;
			for (int i = 0; i < needleLength; i++) 
			{
				if(haystackIndex > (haystackLength - needleLength))
				{
					break;
				}
				if (needleArray[i] == haystackArray[haystackIndex]) 
				{
					isFindWholeNeedle = true;
					haystackIndex++;
					continue;
				} 
				else 
				{
					if (isFindWholeNeedle) 
					{
						isFindWholeNeedle = false;
						resultIndex = -1;
						break;
					}
				}

			}

			if (!isFindWholeNeedle) 
			{
				haystackIndex++;
				if(haystackIndex > (haystackLength - needleLength))
				{
					break;
				}
			}
			else 
				break;
		}
		return resultIndex;
	}
	
	public int strStr2(String haystack, String needle) {
		int needleLength = needle.length();
		int haystackLength = haystack.length();
		if (needleLength <= 0) return 0;
		if (needleLength > haystackLength) return -1;
		int resultIndex = -1;
		for(int i = 0; i <= haystackLength - needleLength; i++)
		{
			String itemhaystack = haystack.substring(i, i + needleLength);
			if(itemhaystack.equals(needle))
			{
				return i;
			}
		}
		return resultIndex;
	}

	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "a";
		ImplementStrStr impStr = new ImplementStrStr();
		System.out.println(impStr.strStr2(str1, str2));
	}
}
