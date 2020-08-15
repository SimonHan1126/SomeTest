package leetcodeNZ.hard;

/**
 * Created by hanshihui on 17/01/19.
 */
public class HARD_10_Regular_Expression_Matching {



    public boolean isMatch(String s, String p) {

        boolean isMatch = false;
        if(!p.contains("\\*") && !p.contains("."))
        {
            if(s.equals(p))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

//        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

//        int sCharArrayLength = sCharArray.length;
        int pCharArrayLength = pCharArray.length;

//        if(sCharArrayLength < pCharArrayLength)
//        {
//            return false;
//        }

//        int sCharArrayIndex = 0;
        int pCharArrayIndex = 0;
        for(;pCharArrayIndex < pCharArrayLength;)
        {
            String pString = pCharArray[pCharArrayIndex] + "";
            if(pString.equals("\\*"))
            {

            }
            else if(pString.equals("."))
            {

            }
            else
            {

            }
        }

        return isMatch;
    }

    public static void main(String[] args) {
        HARD_10_Regular_Expression_Matching h = new HARD_10_Regular_Expression_Matching();
        boolean isMatchOne = h.isMatch("mississippi","mis*is*p*.");
        boolean isMatchTwo = h.isMatch("aab","c*a*b");
        System.out.println("isMatchOne " + isMatchOne + " isMatchTwo " + isMatchTwo);

        String s = "mississippi";
        String p = "mis*is*p*.";

        String[] strArray = p.split("\\*");
        for(String itemLetter : strArray)
        {
            s.indexOf(itemLetter);
            System.out.print(itemLetter + " ");
        }
    }
}
