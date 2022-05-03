package leetcodeNZ.util;

import java.util.Stack;

import leetcodeNZ.model.TreeNode;

public class TreeNodePrintUtil {
    public static void displayTree(TreeNode root)
    {
        Stack<TreeNode> globalStack = new Stack();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while(!isRowEmpty)
        {

            Stack<TreeNode> localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<emptyLeaf; j++)
                System.out.print(' ');
            while(!globalStack.isEmpty())
            {
                TreeNode temp = globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.val);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if(temp.left != null ||temp.right != null)
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
            while(!localStack.isEmpty()) {
                TreeNode temp = localStack.pop();
                globalStack.push(temp);
            }

        }
        System.out.println("****......................................................****");
    }
}
