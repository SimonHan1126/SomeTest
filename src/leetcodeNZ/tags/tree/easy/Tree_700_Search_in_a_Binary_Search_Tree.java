package leetcodeNZ.tags.tree.easy;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_700_Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) return searchBST(root.left, val);
        else if(root.val < val) return searchBST(root.right, val);
        else return root;
    }

    public static void main(String[] args) {
        TreeNode second1 = new TreeNode(1, null, null);
        TreeNode second3 = new TreeNode(3, null, null);
        TreeNode second2 = new TreeNode(2, second1, second3);
        TreeNode second7 = new TreeNode(7, null, null);
        TreeNode second4 = new TreeNode(4, second2, second7);

        TreeNodePrintUtil.displayTree(second4);
        Tree_700_Search_in_a_Binary_Search_Tree object = new Tree_700_Search_in_a_Binary_Search_Tree();

        TreeNodePrintUtil.displayTree(object.searchBST(second4, 1));
        TreeNodePrintUtil.displayTree(object.searchBST(second4, 3));
        TreeNodePrintUtil.displayTree(object.searchBST(second4, 2));
        TreeNodePrintUtil.displayTree(object.searchBST(second4, 7));
        TreeNodePrintUtil.displayTree(object.searchBST(second4, 4));
    }
}
