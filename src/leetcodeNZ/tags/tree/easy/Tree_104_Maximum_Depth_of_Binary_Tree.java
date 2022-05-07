package leetcodeNZ.tags.tree.easy;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

    public static void main(String[] args) {

        TreeNode second1 = new TreeNode(1, null, null);
        TreeNode second3 = new TreeNode(3, null, null);
        TreeNode second2 = new TreeNode(2, second1, second3);
        TreeNode second7 = new TreeNode(7, null, null);
        TreeNode second4 = new TreeNode(4, second2, second7);
        TreeNodePrintUtil.displayTree(second4);
        Tree_104_Maximum_Depth_of_Binary_Tree object = new Tree_104_Maximum_Depth_of_Binary_Tree();
        System.out.println(object.maxDepth(second4));
    }
}
