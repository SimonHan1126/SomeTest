package itinterview.stackandqueue;

import java.util.Stack;

/**
 * @author hanshihui
 * Created by hanshihui on 2017/12/8.
 */
public class RecursiveReserveStack {

    private RecursiveReserveStack()
    {
        init();
    }

    private void init()
    {

    }

    public int getAndRemoveLastElemnt(Stack<Integer> stack)
    {
        int result = stack.pop();
        if(stack.isEmpty())
        {
            System.out.println("1111 result " + result);
            return result;
        }
        else
        {
            System.out.println("2222 result " + result);
            int last = getAndRemoveLastElemnt(stack);
            stack.push(result);
            System.out.println("2222 result " + result + " last " + last);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        RecursiveReserveStack rrStack = new RecursiveReserveStack();
        rrStack.getAndRemoveLastElemnt(stack);
    }
}
