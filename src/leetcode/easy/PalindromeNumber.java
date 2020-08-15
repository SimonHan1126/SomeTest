package leetcode.easy;

public class PalindromeNumber {
	//edit by hsh
	public boolean isPalindrome(int x)
	{
		if(x >= Integer.MAX_VALUE)
		{
			return false;
		}
        
        if(x == 0)
        {
            return true;
        }
		
		if(x < 0)
		{
			return false;
		}
		
		char charArray[] = String.valueOf(x).toCharArray();
		int charArrayLength = charArray.length;
        
        if(charArrayLength == 1)
		{
			return true;
		}
        
        
		
		StringBuffer previousHalf = new StringBuffer();
		StringBuffer lateHalf = new StringBuffer();
		
		for(int i = 0; i < (charArrayLength / 2); i++)
		{
			previousHalf.append(charArray[i]);
		}
		
		int lateIndex = charArrayLength / 2 - 1;
		if(charArrayLength % 2 == 1)
        {
			lateIndex = charArrayLength / 2;
        }
		
		for(int i = charArrayLength - 1; i > lateIndex ; i--)
		{
			lateHalf.append(charArray[i]);
		}
		
		System.out.println(previousHalf.toString() + " " + lateHalf.toString());
		
		if(previousHalf.toString().equals(lateHalf.toString()))
		{
			return true;
		}
		
		return false;
	}
	
	//edit by official
	public boolean IsPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome, 
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
            System.out.println("revertedNumber " + revertedNumber + " x " + x);
        }
        
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123, 
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
	
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		boolean isPalindrome = pn.IsPalindrome(123454321);
		System.out.println("isPalindrome " + isPalindrome);
	}
}
