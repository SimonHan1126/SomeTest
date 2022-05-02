package leetcodeNZ.tree.easy;

import leetcodeNZ.model.TreeNode;

/**
 * @author Simon-the-coder
 * @date 2/05/22 7:06 PM
 */
public class Tree_897_Increasing_Order_Search_Tree {
    public TreeNode increasingBST(TreeNode root) {
        if (root != null) {
//            if (root.left != null) {
//
//            } else if (root.right != null) {
//
//            }
            increasingBST(root.left);
            increasingBST(root.right);
        }
        return root;
     }

    public static void main(String[] args) {

        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n8 = new TreeNode(8, n7, n9);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode n6 = new TreeNode(6, null, n8);
        TreeNode n5 = new TreeNode(5, n3, n6);

        Tree_897_Increasing_Order_Search_Tree obj = new Tree_897_Increasing_Order_Search_Tree();
        obj.increasingBST(n5);
    }
}
