package leetcode.easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length <= 0)
		{
			return "";
		}
		String result = strs[0];
		System.out.println("result " + result);
		int resultLength = result.length();
		if(resultLength <= 0)
		{
			return "";
		}

		for(int i = 1; i < strs.length; i++)
		{
			String itemStr = strs[i];
			System.out.println("itemStr " + itemStr + " i " + i);
			int itemStrLength = itemStr.length();
			
			if(itemStrLength <= 0)
			{
				return "";
			}
			System.out.println("itemStrLength " + itemStrLength + " resultLength "  +resultLength);
			resultLength = result.length();
			if(itemStrLength > resultLength)
			{
				itemStrLength = resultLength;
			}
			else
			{
				result = result.substring(0, itemStrLength);
			}
			for(int j = itemStrLength; j > 0; j--)
			{
				System.out.println("j " + j + " i " +i);
				String itemSingleStr = itemStr.substring(j - 1, j);
				String resultSingleStr = result.substring(j - 1, j);
				if(!resultSingleStr.equals(itemSingleStr))
				{
					result = result.substring(0, j - 1);
				}
			}
		}
		return result;
	}
	
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) return "";
	    String prefix = strs[0];
	    System.out.println("11111" + prefix);
	    for (int i = 1; i < strs.length; i++)
	    {
	    	System.out.println("22222" + strs[i] + " i " + i);
	    	System.out.println("33333" + strs[i].indexOf(prefix));
	    }
//	        while (strs[i].indexOf(prefix) != 0) {
//	            prefix = prefix.substring(0, prefix.length() - 1);
//	            if (prefix.isEmpty()) return "";
//	        }        
	    return prefix;
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] str = {"ABCE","ABCDF","ACDEF"};
		lcp.longestCommonPrefix2(str);
	}
}
