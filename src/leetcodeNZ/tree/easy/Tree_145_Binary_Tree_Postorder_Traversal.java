package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.List;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_145_Binary_Tree_Postorder_Traversal {

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public static void main(String[] args) {
        Integer[] array = {1, null, 2, 3};
        TreeNode node = TreeNode.fromArray(array);
        TreeNodePrintUtil.displayTree(node);
        Tree_145_Binary_Tree_Postorder_Traversal object = new Tree_145_Binary_Tree_Postorder_Traversal();
        List<Integer> resultList = object.postorderTraversal(node);
        for (int i : resultList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
