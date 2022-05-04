package leetcodeNZ.tree.easy;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {

        TreeNode second6 = new TreeNode(6, null, null);
        TreeNode second9 = new TreeNode(9, null, null);
        TreeNode second7 = new TreeNode(7, second6, second9);
        TreeNode second1 = new TreeNode(1, null, null);
        TreeNode second3 = new TreeNode(3, null, null);
        TreeNode second2 = new TreeNode(2, second1, second3);
        TreeNode second4 = new TreeNode(4, second2, second7);
        TreeNodePrintUtil.displayTree(second4);
        Tree_226_Invert_Binary_Tree object = new Tree_226_Invert_Binary_Tree();
        TreeNodePrintUtil.displayTree(object.invertTree(second4));
    }
}
