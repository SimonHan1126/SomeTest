package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.List;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_144_Binary_Tree_Preorder_Traversal {

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public static void main(String[] args) {
        Integer[] array = {1, null, 2, 3};
        TreeNode node = TreeNode.fromArray(array);
        TreeNodePrintUtil.displayTree(node);
        Tree_144_Binary_Tree_Preorder_Traversal object = new Tree_144_Binary_Tree_Preorder_Traversal();
        List<Integer> resultList = object.preorderTraversal(node);
        for (int i : resultList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
