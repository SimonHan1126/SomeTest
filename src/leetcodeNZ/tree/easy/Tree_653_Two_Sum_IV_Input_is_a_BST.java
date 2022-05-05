package leetcodeNZ.tree.easy;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_653_Two_Sum_IV_Input_is_a_BST {

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        traversal(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        while (k > 0) {

        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] array = {5,3,6,2,4,null,7};
        TreeNode node = TreeNode.fromArray(array);
        TreeNodePrintUtil.displayTree(node);
        Tree_653_Two_Sum_IV_Input_is_a_BST object = new Tree_653_Two_Sum_IV_Input_is_a_BST();
        object.findTarget(node, 9);
    }
}
