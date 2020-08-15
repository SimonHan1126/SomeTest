package leetcodeNZ.easy;

/**
 * Created by hanshihui on 5/07/19.
 */
public class EASY_7_Reverse_Integer {

    public int reverse(int x) {
        System.out.println("=================== " + x);
        if(x>-10 && x < 10)
        {
            return x;
        }

        String finalStr = "";
        boolean isPositive = true;
        int endPosition = -1;
        if(x < 0)
        {
            isPositive = false;
            endPosition = 0;
        }

        String tempStr = x + "";
        char[] cArray = tempStr.toCharArray();
        int tempStrLength = tempStr.length();
        for(int i = tempStrLength - 1; i > endPosition; i--)
        {
            finalStr += cArray[i];
        }

        long finalResult = isPositive == true ? new Long(finalStr) : -new Long(finalStr);
        if(finalResult > Integer.MAX_VALUE)
        {
            return 0;
        }

        if(finalResult < Integer.MIN_VALUE)
        {
            return 0;
        }

        return (int) finalResult;
    }

    public static void main(String[] args) {
        EASY_7_Reverse_Integer eri = new EASY_7_Reverse_Integer();
//        System.out.println(eri.reverse(-194));
//        System.out.println(eri.reverse(1999999999));
//        System.out.println(eri.reverse(-9191918));
//        System.out.println(eri.reverse(-9));
//        System.out.println(eri.reverse(12434));
        System.out.println(eri.reverse(-2147483648));
    }
}
