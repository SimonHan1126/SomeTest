package leetcodeNZ.medium;

/**
 * Created by hanshihui on 17/01/19.
 */
public class Medium_3_longest_no_repeat_character {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        if(s.length() <= 0)
        {
            return length;
        }

        char[] charArray = s.toCharArray();
        String longestSubstring = "";
        for(char c : charArray)
        {
            String itemC = c + "";
            int iRepeatIndex = longestSubstring.indexOf(itemC);
            if(iRepeatIndex >= 0)
            {
                longestSubstring = longestSubstring.substring(iRepeatIndex + 1, longestSubstring.length()) + itemC;
            }
            else
            {
                longestSubstring = longestSubstring + itemC;
                int newLength = longestSubstring.length();
                if(newLength > length)
                {
                    length = newLength;
                }
            }
            System.out.println("longestSubstring " + longestSubstring + " iRepeatIndex " + iRepeatIndex + " c " + c);
        }

        return length;
    }

    public static void main(String[] args) {
        Medium_3_longest_no_repeat_character m = new Medium_3_longest_no_repeat_character();
        int a = m.lengthOfLongestSubstring("dvdf");
        int b = 0;//m.lengthOfLongestSubstring("bbbbbb");
        int c = 0;//m.lengthOfLongestSubstring("pwwkew");
        System.out.println("a " + a + " b " + b + " c " + c);
//        String s = "dvef";
//        int repeatIndex = s.indexOf("d");
//        String newStr = s.substring(repeatIndex + 1,s.length());
//        System.out.println(newStr);
    }
}
