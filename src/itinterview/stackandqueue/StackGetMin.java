package itinterview.stackandqueue;

import java.util.Stack;

/**
 * @author hanshihui
 * Created by hanshihui on 2017/12/6.
 */
public class StackGetMin {

    private Stack<Integer> allNumStack;
    private Stack<Integer> minNumStack;

    public StackGetMin() {
        this.allNumStack = new Stack<>();
        this.minNumStack = new Stack<>();
    }

    public void push(int n)
    {
        allNumStack.push(n);
        if (minNumStack.isEmpty())
        {
            minNumStack.push(n);
        }
        else
        {
            int peekNum = minNumStack.peek();
            if(n <= peekNum)
            {
                minNumStack.push(n);
            }
        }
    }

    public int pop() throws Exception
    {
        if(allNumStack.isEmpty())
        {
            throw new Exception("allNumStack is empty");
        }
        int value = allNumStack.pop();
        int minNum = getMin();
        if(value == minNum)
        {
            minNumStack.pop();
        }
        return value;
    }

    public int getMin() throws Exception {
        if(minNumStack.isEmpty())
        {
            throw new Exception("minNumStack is empty");
        }
        return minNumStack.peek();
    }

    public static void main(String[] args)
    {
        StackGetMin min = new StackGetMin();
        min.push(2);
        min.push(5);
        min.push(8);
        min.push(-2);
        min.push(-20000000);
        min.push(992);
        min.push(2222);
        min.push(21);
        min.push(0);

        try {
            int min1 = min.getMin();
            int min2 = min.getMin();
            min.pop();
            int min3 = min.getMin();
            int min4 = min.getMin();
            min.pop();
            int min5 = min.getMin();
            min.pop();
            int min6 = min.getMin();
            int min7 = min.getMin();
            min.pop();
            int min8 = min.getMin();
            min.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
