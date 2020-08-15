package test;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hanshihui
 */
public class PrintBinaryTreeFringe {

    /**
     * 标准一：
     * 1．头节点为边界节点。
     * 2．叶节点为边界节点。
     * 3．如果节点在其所在的层中是最左或最右的，那么也是边界节点。
     *
     * 打印结果为：1，2，4，7，11，13，14，15，16，12，10，6，3
     */
    public void printFirstBTree(Node head)
    {
        if(head == null)
        {
            return;
        }
        Node firstLeft = head.left;

        Node firstRight = head.right;

        Stack<Node> iteratorStack = new Stack<>();
        iteratorStack.push(firstLeft);
        Queue<Node> printQueue = new LinkedList<>();
        printQueue.add(head);
        printQueue.add(firstLeft);
        Node curNode;
        while (!iteratorStack.isEmpty())
        {
            curNode = iteratorStack.pop();

            if(curNode.left != null)
            {
                printQueue.add(curNode.left);
            }

            if(curNode.right != null)
            {
                iteratorStack.push(curNode.right);
                if(curNode.right.left == null && curNode.right.right == null)
                {
                    printQueue.add(curNode.right);
                }
            }

            if(curNode.left != null)
            {
                iteratorStack.push(curNode.left);
            }

            if(curNode.left == null && curNode.right != null)
            {
                printQueue.add(curNode.right);
            }
        }

        Stack<Node> printStack = new Stack<>();
        printStack.push(firstRight);
        iteratorStack.push(firstRight);
        while (!iteratorStack.isEmpty())
        {
            curNode = iteratorStack.pop();
            if(curNode.right != null)
            {
                printStack.push(curNode.right);
                iteratorStack.push(curNode.left);
            }

            if(curNode.left != null)
            {
                iteratorStack.push(curNode.left);
                if(curNode.left.left == null && curNode.left.right == null)
                {
                    printStack.add(curNode.left);
                }
            }

            if(curNode.left != null && curNode.right == null)
            {
                printStack.add(curNode.left);
            }
        }

        while (!printStack.isEmpty())
        {
            System.out.print(printStack.pop().value + " ");
        }
    }

    /**
     * 1．头节点为边界节点。
     * 2．叶节点为边界节点。
     * 3．树左边界延伸下去的路径为边界节点。
     * 4．树右边界延伸下去的路径为边界节点。
     *
     * 打印结果为：1，2，4，7，13，14，15，16，10，6，3
     */
    public void printSecondBTree(Node head)
    {

    }

    public static void main(String[] args) {
        Node[] nodeArray = new Node[16];
        for (int i = 0; i < nodeArray.length; i++) {
            nodeArray[i] = new Node(i + 1);
        }

        nodeArray[0].left = nodeArray[1];
        nodeArray[0].right = nodeArray[2];

        nodeArray[1].right = nodeArray[3];

        nodeArray[3].left = nodeArray[6];
        nodeArray[3].right = nodeArray[7];

        nodeArray[7].right = nodeArray[10];

        nodeArray[10].left = nodeArray[12];
        nodeArray[10].right = nodeArray[13];

        nodeArray[2].left = nodeArray[4];
        nodeArray[2].right = nodeArray[5];

        nodeArray[4].left = nodeArray[8];
        nodeArray[4].right = nodeArray[9];

        nodeArray[8].left = nodeArray[11];

        nodeArray[11].left = nodeArray[14];
        nodeArray[11].right = nodeArray[15];

        PrintBinaryTreeFringe printBTree = new PrintBinaryTreeFringe();
        printBTree.printFirstBTree(nodeArray[0]);


        System.out.println("Runtime.getRuntime().availableProcessors() " + Runtime.getRuntime().availableProcessors());
    }
}

class Node {

    public int value;

    public Node left;

    public Node right;

    public Node(int data) {

        this.value = data;

    }

}


