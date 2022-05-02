package leetcodeNZ.example;
import java.io.*;
import java.util.*;

/**
 * @author Simon-the-coder
 * @date 1/05/22 10:46 AM
 */

class Node {
    int key;
    Node leftChild, rightChild;

    public Node(int data){
        key = data;
        leftChild = rightChild = null;
    }
}

//class Node
//{
//    public int item;
//    public Node leftChild;
//    public Node rightChild;
//    public void displayNode()
//    {
//        System.out.print("[");
//        System.out.print(item);
//        System.out.print("]");
//    }
//}

class StackNode
{
    public Node item;
    public StackNode next;
    public StackNode(Node val)
    {
        item = val;
    }

}
class LinkedListStack
{
    private StackNode first;
    public LinkedListStack()
    {
        first = null;
    }
    public boolean isEmpty()
    {
        return (first==null);
    }
    public void insert(Node key)//inserts at beginning of list
    {
        StackNode newLLNode = new StackNode(key);
        newLLNode.next = first;
        first = newLLNode;
    }
    public Node delete()//deletes at beginning of list
    {
        StackNode temp = first;
        first = first.next;
        return temp.item;
    }
}
class Stack
{
    private LinkedListStack listObj;
    public Stack()
    {
        listObj = new LinkedListStack();
    }
    public void push(Node num)
    {
        listObj.insert(num);
    }
    public Node pop()
    {
        return listObj.delete();
    }
    public boolean isEmpty()
    {
        return listObj.isEmpty();
    }
}

class Tree
{
    public Node root;
    public Tree()
    { root = null; }
    public Node returnRoot()
    {
        return root;
    }

    // insert a node in BST
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.leftChild = insert_Recursive(root.leftChild, key);
        else if (key > root.key)    //insert in the right subtree
            root.rightChild = insert_Recursive(root.rightChild, key);
        // return pointer
        return root;
    }

    public void preOrder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.key + " ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    public void inOrder(Node root)
    {
        if(root != null)
        {
            inOrder(root.leftChild);
            System.out.print(root.key + " ");
            inOrder(root.rightChild);
        }
    }
    public void postOrder(Node root)
    {
        if(root != null)
        {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.print(root.key + " ");
        }
    }

    public void byLevel(Node root){
        Queue<Node> level	= new LinkedList<>();
        level.add(root);

        while(!level.isEmpty()){
            Node node = level.poll();
            System.out.print(node.key + " ");
            if(node.leftChild!= null)
                level.add(node.leftChild);
            if(node.rightChild!= null)
                level.add(node.rightChild);
        }
    }

    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while(isRowEmpty==false)
        {

            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<emptyLeaf; j++)
                System.out.print(' ');
            while(globalStack.isEmpty()==false)
            {
                Node temp = globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.key);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null ||temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<emptyLeaf*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println("****......................................................****");
    }

    public static void main(String[] args) throws IOException
    {
        int value;
        Tree theTree = new Tree();
        theTree.insert(42);
        theTree.displayTree();
        theTree.insert(25);
        theTree.displayTree();
        theTree.insert(65);
        theTree.displayTree();
        theTree.insert(12);
        theTree.displayTree();
        theTree.insert(37);
        theTree.displayTree();
        theTree.insert(13);
        theTree.displayTree();
        theTree.insert(30);
        theTree.displayTree();
        theTree.insert(43);
        theTree.displayTree();
        theTree.insert(87);
        theTree.displayTree();
        theTree.insert(99);
        theTree.displayTree();
        theTree.insert(9);
        theTree.displayTree();
        theTree.insert(10);
        theTree.displayTree();
        theTree.insert(64);
        theTree.displayTree();


        System.out.println("Displaying the tree");
        theTree.displayTree();

        System.out.println("Inorder traversal");
        theTree.inOrder(theTree.returnRoot());
        System.out.println(" ");

        System.out.println("Preorder traversal");
        theTree.preOrder(theTree.returnRoot());
        System.out.println(" ");

        System.out.println("Postorder traversal");
        theTree.postOrder(theTree.returnRoot());
        System.out.println(" ");

        System.out.println("By Level");
        theTree.byLevel(theTree.returnRoot());
        System.out.println(" ");
    }
}
