package leetcodeNZ.tags.topInterviewQuestions;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class TIQ_101_Symmetric_Tree {

    private String traversal(TreeNode node, boolean isLeftNode) {
        if (node == null) return "null";
        String left = traversal(node.left, isLeftNode);
        String right = traversal(node.right, isLeftNode);
        return (isLeftNode ? right + "-" + left : left + "-" + right) + "-" + node.val;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return traversal(root.left, true).equals(traversal(root.right, false));
    }

    public static void main(String[] args) {
//        Integer[] array = {1,2,2,3,4,4,3};
//        Integer[] array = {1,2,2,null,3,null,3};
        Integer[] array = {1,2,2,null,3,null,3};
        TreeNode node = TreeNode.fromArray(array);

        TreeNodePrintUtil.displayTree(node);
        TIQ_101_Symmetric_Tree object = new TIQ_101_Symmetric_Tree();
        System.out.println(object.isSymmetric(node));
    }
}
