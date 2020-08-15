package leetcode.easy;

public class ReverserInteger {
	
	//edit by hsh
	public int reverse(int x) {
		if (x == 0) {
			return x;
		}

		if (x <= Integer.MIN_VALUE) {
			return 0;
		}

		StringBuffer targetSB = new StringBuffer();
		if (x < 0) {
			targetSB.append("-");
			x = -x;
		}
		char charArray[] = String.valueOf(x).toCharArray();
		for (int i = (charArray.length - 1); i >= 0; i--) {
			targetSB.append(charArray[i]);
		}
		long targetLong = Long.valueOf(targetSB.toString());
		if (targetLong > Integer.MAX_VALUE) {
			return 0;
		}
		if (targetLong < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) targetLong;
	}
	
	//edit by leetcoder
	public int reverseSec(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            System.out.println("result " + result + " newResult " + newResult + " tail " + tail);
            int temp = newResult - tail;
            int tempSec = temp / 10;
            if ((newResult - tail) / 10 != result)
            { 
            	System.out.println("if temp " + temp + " newResult " + newResult + " tail " + tail + " tempSec " + tempSec + " result " + result);
            	return 0; 
            }
            else
            {
            	System.out.println("else temp " + temp +" newResult " + newResult + " tail " + tail + " tempSec " + tempSec + " result " + result);
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

	public static void main(String[] args) {
		ReverserInteger ri = new ReverserInteger();
		System.out.println(ri.reverseSec(-2147483648));
		System.out.println("------------------------");
		int a = -846384741;
		int b = a * 10 + -2;
		System.out.println(a * 10);
		System.out.println("bb " + Integer.MAX_VALUE);
		System.out.println("cc " + b);
		System.out.println("a " + a + " b " + b);
		System.out.println(Integer.MIN_VALUE - 126087180);
		long longOne = 4168880114L;//6316363762L;//846384741L * 10 ;
		long longTwo = longOne + Integer.MIN_VALUE;
		System.out.println("longOne " + longOne + " longTwo " + longTwo);
		System.out.println(2021396468L - 2147483647);
	}
}
