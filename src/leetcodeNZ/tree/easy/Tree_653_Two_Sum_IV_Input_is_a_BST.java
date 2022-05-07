package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.List;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_653_Two_Sum_IV_Input_is_a_BST {

//    private List<Integer> nodeValueList = new ArrayList<>();
//    private void traversal(TreeNode root) {
//        if (root == null) return;
//        traversal(root.left);
//        traversal(root.right);
//        nodeValueList.add(root.val);
//    }
//
//    public boolean findTarget(TreeNode root, int k) {
//        traversal(root);
//        for (int i = 0; i < nodeValueList.size(); i++) {
//            int subValue = k - nodeValueList.get(i);
//            for (int j = 0; j < nodeValueList.size(); j++) {
//                if (i != j && subValue == nodeValueList.get(j)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    private boolean b = false;
    private void traversal(TreeNode root, List<Integer> nodeValueList, int k) {
        if (root == null) return;
        traversal(root.left, nodeValueList, k);
        traversal(root.right, nodeValueList, k);
        if (nodeValueList.contains(root.val)) {
            b = true;
            return;
        }
        nodeValueList.add(k - root.val);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nodeValueList = new ArrayList<>();
        traversal(root, nodeValueList, k);
        return b;
    }

    public static void main(String[] args) {
        Integer[] array = {5,3,6,2,4,null,7};
        TreeNode node = TreeNode.fromArray(array);
        TreeNodePrintUtil.displayTree(node);
        Tree_653_Two_Sum_IV_Input_is_a_BST object = new Tree_653_Two_Sum_IV_Input_is_a_BST();
        object.findTarget(node, 9);
    }
}
