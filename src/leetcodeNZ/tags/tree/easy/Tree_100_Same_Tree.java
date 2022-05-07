package leetcodeNZ.tags.tree.easy;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_100_Same_Tree {


    private void traversal(TreeNode root, StringBuffer tree2str) {
        if (root == null) return;
        System.out.println("=====>" + root.val);
        tree2str.append(root.val + "-");
        if (root.left == null) tree2str.append("*");
        if (root.right == null) tree2str.append("&");
        System.out.println(tree2str);
        traversal(root.left, tree2str);
        traversal(root.right, tree2str);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuffer tree2str1 = new StringBuffer();
        StringBuffer tree2str2 = new StringBuffer();
        traversal(p, tree2str1);
        traversal(q, tree2str2);
        return tree2str1.toString().equals(tree2str2.toString());
    }

//    private void traversal(TreeNode root, String tree2str) {
//        if (root == null) return;
//        System.out.println("=====>" + root.val);
//        tree2str += root.val + "-";
//        System.out.println(tree2str);
//        traversal(root.left, tree2str);
//        traversal(root.right, tree2str);
//    }
//
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        String tree2str1 = "";
//        String tree2str2 = "";
//        traversal(p, tree2str1);
//        System.out.println("tree2str1 " + tree2str1);
//        traversal(q, tree2str2);
//        System.out.println("tree2str2 " + tree2str2);
//        return tree2str1.equals(tree2str2);
//    }

    public static void main(String[] args) {
//        Integer[] array = {6,2,8,0,4,7,9,null,null,3,5}; // {6,2,8,0,4,7,9,3,5}; // {1,2};
//        Integer[] array = {1,2};
        Integer[] array = {10,5,null,null,15};
        TreeNode node = TreeNode.fromArray(array);
        TreeNodePrintUtil.displayTree(node);

//        Integer[] array2 =  {1,null,2};
        Integer[] array2 = {10,5,15};;
        TreeNode node2 = TreeNode.fromArray(array2);
        TreeNodePrintUtil.displayTree(node2);
        Tree_100_Same_Tree object = new Tree_100_Same_Tree();
        System.out.println(object.isSameTree(node, node2));
    }
}
