package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

//        double average = ((root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val)) / 2;
//        list.add(average);

public class Tree_637_Average_of_Levels_in_Binary_Tree {
//    private List<Double> list = new ArrayList<>();
//    public void averageOfLevel(TreeNode root) {
//        if (root == null) return;
//        if (root.left != null && root.right != null) list.add(new Double(root.left.val + root.right.val)/ 2);
//        if (root.left == null && root.right != null) list.add(new Double(root.right.val));
//        if (root.left != null && root.right == null) list.add(new Double(root.left.val));
//        averageOfLevel(root.left);
//        averageOfLevel(root.right);
//    }
//
//    public List<Double> averageOfLevels(TreeNode root) {
//        if (root == null) return list;
//        list.add(new Double(root.val));
//        averageOfLevel(root);
//        return list;
//    }

    private List<Double> list = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return list;
        averageOfLevel(root);
        return list;
    }

    public void averageOfLevel(TreeNode root) {
        Stack<TreeNode> globalStack = new Stack<>();
        globalStack.push(root);
        int levelNodeCount = globalStack.size();
        boolean isLoop = true;
        while (isLoop) {
            double sum = 0;
            List<TreeNode> arrayList = new ArrayList<>();
            for (int i = 0; i < levelNodeCount; i++) {
                TreeNode node = globalStack.pop();
                if (node != null) {
                    sum += node.val;
                    arrayList.add(node);
                }
            }

            for (TreeNode node : arrayList) {
                if (node.left != null) globalStack.push(node.left);
                if (node.right != null) globalStack.push(node.right);
            }
            list.add(sum / levelNodeCount);
            levelNodeCount = globalStack.size();
            isLoop = levelNodeCount > 0;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3, 1, 5, 0, 2, 4, 6};
        TreeNode node = TreeNode.fromArray(array);

        TreeNodePrintUtil.displayTree(node);
        Tree_637_Average_of_Levels_in_Binary_Tree object = new Tree_637_Average_of_Levels_in_Binary_Tree();
        System.out.println(object.averageOfLevels(node));
    }
}
