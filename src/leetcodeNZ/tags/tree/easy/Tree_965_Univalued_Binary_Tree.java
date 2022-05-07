package leetcodeNZ.tags.tree.easy;

import leetcodeNZ.model.TreeNode;

public class Tree_965_Univalued_Binary_Tree {

    private boolean isUnivalTree = true;
    private int val;

    private void inOrder(TreeNode root) {
        if (root == null) return;
        if (root.val != val) {
            isUnivalTree = false;
        }
        inOrder(root.left);
        inOrder(root.right);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;
        val = root.val;
        inOrder(root);
        return isUnivalTree;
    }

    public static void main(String[] args) {
        TreeNode second1 = new TreeNode(2, null, null);
        TreeNode second2 = new TreeNode(2, null, null);
        TreeNode second3 = new TreeNode(5, second1, second2);
        TreeNode second4 = new TreeNode(2, null, null);
        TreeNode second5 = new TreeNode(2, second3, second4);
        Tree_965_Univalued_Binary_Tree object = new Tree_965_Univalued_Binary_Tree();
        System.out.println(object.isUnivalTree(second5));
    }
}
