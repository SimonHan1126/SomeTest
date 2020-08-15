package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s)
	{
		if (s == null || s.length() <= 1) {
			return false;
		}
		String[] parentheses = { "()", "{}", "[]" };
		while(s.contains(parentheses[0]) || s.contains(parentheses[1]) || s.contains(parentheses[2]))
		{
			for(int i = 0; i < parentheses.length; i++)
			{
				String itemParenthese = parentheses[i];
				int index = s.indexOf(itemParenthese);
				if(index != -1)
				{
					String tempStrOne = s.substring(0, index);
					String tempStrTwo = s.substring(index + itemParenthese.length(), s.length());
					s = tempStrOne + tempStrTwo;
				}
			}
		}
		
		if(s.length() > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public boolean leeterCoderCode(String s)
	{
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses vp = new ValidParentheses();
		// System.out.println(vp.isValidParentheses("[)[}[[{]}][]){[()]{[]]}"));
		// System.out.println(vp.isValidParentheses("[{]"));
		// System.out.println(vp.isValidParentheses("(([]){})"));
		// System.out.println(vp.isValidParentheses("[()](())"));
		// System.out.println(vp.isValidParentheses("[{()}]"));
//		System.out.println(vp.isValidParentheses("[(({})}]"));
//		System.out.println(vp.isValid("[({(())}[()])]"));
//		System.out.println(vp.leeterCoderCode("[({(())}[()])]"));
		System.out.println(vp.leeterCoderCode("[{]"));
	}

}
