package leetcodeNZ.tags.tree.easy;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return null;
    }

    public static void main(String[] args) {
        Integer[] array = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode node = TreeNode.fromArray(array);
        TreeNodePrintUtil.displayTree(node);
        Tree_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree object = new Tree_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        TreeNode node2 = node.left;
        TreeNode node9 = node.right.right;
        System.out.println("node2 " + node2.val + " node9.val " + node9.val);
        object.lowestCommonAncestor(node, node2, node9);
    }
}
