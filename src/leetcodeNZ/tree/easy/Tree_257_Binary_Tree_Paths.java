package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_257_Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        System.out.println(root.val);
        TreeNodePrintUtil.displayTree(root);
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
            System.out.println(answer);
        }
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Integer[] array2 = {1,2,3,5,6};
//        Integer[] array = {1,2,3,null,5};
//        Integer[] array = {1};
//        Integer[] array = {1,null,3};
        TreeNode node = TreeNode.fromArray(array);
//        TreeNode node2 = TreeNode.fromArray(array2);
        TreeNodePrintUtil.displayTree(node);
//        TreeNodePrintUtil.displayTree(node2);
        System.out.println("-----------------------------");
        Tree_257_Binary_Tree_Paths object = new Tree_257_Binary_Tree_Paths();
        object.binaryTreePaths(node);
//        System.out.println("-----------------------------");
//        System.out.println(object.binaryTreePaths(node2));
    }
}
