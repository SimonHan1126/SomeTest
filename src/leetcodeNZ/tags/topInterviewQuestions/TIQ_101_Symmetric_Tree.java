package leetcodeNZ.tags.topInterviewQuestions;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class TIQ_101_Symmetric_Tree {

    private void preOrderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void postOrderTraversal(TreeNode node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

    public boolean isSymmetric(TreeNode root) {
        System.out.print("preOrderTraversal: ");
        preOrderTraversal(root.left);
        System.out.println();
        System.out.print("postOrderTraversal: ");
        postOrderTraversal(root.right);
        System.out.println();
        return false;
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,2,3,4,4,3,5,6,7,8,8,7,6,5};
        TreeNode node = TreeNode.fromArray(array);

        TreeNodePrintUtil.displayTree(node);
        TIQ_101_Symmetric_Tree object = new TIQ_101_Symmetric_Tree();
        object.isSymmetric(node);
    }
}
