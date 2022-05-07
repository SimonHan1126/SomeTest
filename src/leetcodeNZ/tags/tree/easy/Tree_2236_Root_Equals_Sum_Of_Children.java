package leetcodeNZ.tags.tree.easy;

import leetcodeNZ.model.TreeNode;

/**
 * @author Simon-the-coder
 * @date 1/05/22 5:25 PM
 */
public class Tree_2236_Root_Equals_Sum_Of_Children {
    public boolean checkTree(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null);
        return root.val == ((root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val));
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(4, null, null);
        TreeNode right = new TreeNode(6, null, null);
        TreeNode root = new TreeNode(10, left, right);

        Tree_2236_Root_Equals_Sum_Of_Children object = new Tree_2236_Root_Equals_Sum_Of_Children();
        object.checkTree(root);
    }
}
