package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.List;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_606_Construct_String_from_Binary_Tree {

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
        System.out.println(root.val);

    }

//    public String tree2str(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root,list);
//        System.out.println(list);
//        return "";
//    }

    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        System.out.println("left " + left + " | right " + right);
        if(left == "" && right == "") return  t.val + "";

        return t.val + "(" + left  + ")" + (right == "" ? "" : "(" + right + ")");
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4};
//        Integer[] array = {1,2,3,null,4};
        TreeNode node = TreeNode.fromArray(array);
        TreeNodePrintUtil.displayTree(node);
        System.out.println("-----------------------------");
        Tree_606_Construct_String_from_Binary_Tree object = new Tree_606_Construct_String_from_Binary_Tree();
        System.out.println(object.tree2str(node));
    }
}
