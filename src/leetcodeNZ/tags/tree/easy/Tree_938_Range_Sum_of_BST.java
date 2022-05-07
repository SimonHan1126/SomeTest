package leetcodeNZ.tags.tree.easy;

import leetcodeNZ.model.TreeNode;

/**
 * @author Simon-the-coder
 * @date 1/05/22 6:36 PM
 */
public class Tree_938_Range_Sum_of_BST {

    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val >= low && root.val <= high) sum += root.val;
        rangeSumBST(root.left,  low, high);
        rangeSumBST(root.right, low, high);
        return sum;
    }

    public static void main(String[] args) {

        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n5 = new TreeNode(5, n3, n7);
        TreeNode n18 = new TreeNode(18, null, null);
        TreeNode n15 = new TreeNode(15, null, n18);
        TreeNode n10 = new TreeNode(10, n5, n15);

        Tree_938_Range_Sum_of_BST object = new Tree_938_Range_Sum_of_BST();
        object.rangeSumBST(n10, 7, 15);
    }
}
