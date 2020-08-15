package itinterview.stackandqueue;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author hanshihui
 * Created by hanshihui on 2017/12/9.
 */
public class StackSortStack {
    public Stack sort(Stack<Integer> stack)
    {
        if(stack == null || stack.isEmpty())
        {
            return stack;
        }

        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty())
        {
            int num = stack.peek();

            Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext())
            {
                int curNum = iterator.next();
                if (curNum < num) {
                    num = curNum;
                }
            }

            tempStack.push(num);
            stack.remove(new Integer(num));
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(33);
        stack.push(23);
        stack.push(12);
        stack.push(3);

        StackSortStack ssStack = new StackSortStack();
        stack = ssStack.sort(stack);
        while (stack != null && !stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
    }
}

