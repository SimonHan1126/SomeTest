package leetcodeNZ.tags.topInterviewQuestions;

import java.util.Stack;

public class TIQ_125_Valid_Palindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return true;
        Stack<Character> stack = new Stack<>();
        char charArray[] = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int char2int = charArray[i];
            int lowercaseInt = (char2int >= 65 && char2int <= 90) ? char2int + 32 : char2int;
            System.out.println("lowercaseInt " + lowercaseInt);
            if ((lowercaseInt >= 97 && lowercaseInt <= 122) || (lowercaseInt >= 48 && lowercaseInt <= 57)) {
                stack.push((char)lowercaseInt);
            }
        }
        System.out.println(s);
        System.out.println(stack);
        System.out.println("****************************");
        while (stack.size() > 1) {
            char firstElement = stack.firstElement();
            char lastElement = stack.pop();
            if (firstElement != lastElement) return false;
            stack.remove(0);
        }
        return true;
    }

    public static void main(String[] args) {
        char cArray[] = {'0','1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < cArray.length; i++) {
            int item = cArray[i];
            System.out.println("i " + i + " toChar " + item);
        }


        TIQ_125_Valid_Palindrome object = new TIQ_125_Valid_Palindrome();
//        System.out.println(object.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(object.isPalindrome("race a car"));
        System.out.println(object.isPalindrome("0P"));
//        System.out.println(object.isPalindrome("A"));
//        System.out.println(object.isPalindrome("b"));
    }
}
