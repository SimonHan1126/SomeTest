package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.List;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

//        double average = ((root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val)) / 2;
//        list.add(average);

public class Tree_637_Average_of_Levels_in_Binary_Tree {
    private List<Double> list = new ArrayList<>();
    public void averageOfLevel(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.right != null) list.add(new Double(root.left.val + root.right.val)/ 2);
        if (root.left == null && root.right != null) list.add(new Double(root.right.val));
        if (root.left != null && root.right == null) list.add(new Double(root.left.val));
        averageOfLevel(root.left);
        averageOfLevel(root.right);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return list;
        list.add(new Double(root.val));
        averageOfLevel(root);
        return list;
    }

    public static void main(String[] args) {
//        TreeNode second1 = new TreeNode(15, null, null);
//        TreeNode second3 = new TreeNode(7, null, null);
//        TreeNode second2 = new TreeNode(20, second1, second3);
//        TreeNode second7 = new TreeNode(9, null, null);
//        TreeNode second4 = new TreeNode(3, second7, second2);

        TreeNode second1 = new TreeNode(1, null, null);
        TreeNode second2 = new TreeNode(1, second1, null);

        TreeNodePrintUtil.displayTree(second2);
        Tree_637_Average_of_Levels_in_Binary_Tree object = new Tree_637_Average_of_Levels_in_Binary_Tree();
        System.out.println(object.averageOfLevels(second2));
    }
}
