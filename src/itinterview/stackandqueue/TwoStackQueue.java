package itinterview.stackandqueue;

import java.util.Random;
import java.util.Stack;

/**
 * @author hanshihui
 * Created by hanshihui on 2017/12/6.
 */
public class TwoStackQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public TwoStackQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately
     * without violating capacity restrictions, returning true upon success and throwing an
     * IllegalStateException if no space is currently available.
     *
     * @param num
     * @return true if this collection changed as a result of the call
     */
    public boolean add(int num)
    {
        pushStack.push(num);
        return true;
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    public int roll() throws Exception {
        if(popStack.isEmpty())
        {
            boolean result = copyToAnotherStack(pushStack,popStack);
            if(result)
            {
                return popStack.pop();
            }
            else
            {
                throw new Exception("Queue is empty");
            }
        }
        else
        {
            return popStack.pop();
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    public int peek() throws Exception {

        if(popStack.isEmpty())
        {
            boolean result = copyToAnotherStack(pushStack,popStack);
            if(result)
            {
                return popStack.peek();
            }
            else
            {
                throw new Exception("Queue is empty");
            }
        }
        else
        {
            return popStack.peek();
        }

    }

    private boolean copyToAnotherStack(Stack originalStack, Stack targetStack) {
        if(originalStack.isEmpty() || !targetStack.isEmpty())
        {
            return false;
        }
        while (!pushStack.isEmpty())
        {
            popStack.push(pushStack.pop());
        }
        return true;
    }

    public static void main(String[] args) {
        TwoStackQueue tsq = new TwoStackQueue();
        Random r = new Random();

        int whileTimes = 10;
        while(whileTimes > 0)
        {
            int curRandomNum = r.nextInt(100);
            if(curRandomNum > 66)
            {
                int peekNum = 0;
                try {
                    peekNum = tsq.peek();
//                    System.out.println("peedNum " + peekNum);
                } catch (Exception e) {
                    tsq.add(whileTimes);
                    System.out.println("1111 addNum " + whileTimes);
                    whileTimes--;
                    e.printStackTrace();
                }

            }
            else if(curRandomNum > 33 && curRandomNum <= 66)
            {
                int roolNum = 0;
                try {
                    roolNum = tsq.roll();
                    System.out.println("roll " + roolNum);
                } catch (Exception e) {
                    tsq.add(whileTimes);
                    System.out.println("22222 addNum " + whileTimes);
                    whileTimes--;
                    e.printStackTrace();
                }

            }
            else
            {
                tsq.add(whileTimes);
                System.out.println("addNum " + whileTimes);
                whileTimes--;
            }
        }
    }
}
