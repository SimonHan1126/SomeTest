package leetcodeNZ.tree.easy;

import java.util.ArrayList;
import java.util.List;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

public class Tree_872_Leaf_Similar_Trees {
    private String treeValuesString1;
    private String treeValuesString2;
    private void inOrder(TreeNode root, boolean isFirstTree) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (isFirstTree) {
                treeValuesString1 += root.val + "-";
            } else {
                treeValuesString2 += root.val + "-";
            }
        }
        inOrder(root.left, isFirstTree);
        inOrder(root.right,isFirstTree);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        inOrder(root1, true);
        inOrder(root2, false);
        return treeValuesString1.equals(treeValuesString2);
    }
    public List<Integer> list = new ArrayList<>();
    private void getLeaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        getLeaves(root.left);
        getLeaves(root.right);
    }

    public static void main(String[] args) {
//        [3,5,1,6,2,9,8,null,null,7,14]
//        [3,5,1,6,71,4,2,null,null,null,null,null,null,9,8]
        Tree_872_Leaf_Similar_Trees object = new Tree_872_Leaf_Similar_Trees();
//        Integer[] integerArray1 = {3,5,1,6,2,9,8,null,null,7,4};
        Integer[] integerArray1 = {3,5,1,6,2,9,8,null,null,7,14};
//        Integer[] integerArray1 = {105,117,null,82,38,115,10,null,40,44,6,61,19,null,null,8,24,104,107,4,90,8,113,27,116,77,null,25,67,14,null,46,19,100,10,121,63,null,109,113,59,97,91,109,39,60,57,null,90,98,70,49,null,null,15,88,68,30,110,120,83,50,45,null,null,56,115,null,18,116,64,90,null,null,40,111,104,110,9,83,15,84,64,36,101,null,94,100,39,46,117,116,91,null,42,80,47,46,50,36,3,88,64,46,8,57,89,43,null,90,109,47,12,39,17,null,null,null,60,32,67,72,null,null,null,34,57,null,null,27,121,99,null,112,null,32,null,29,null,40,19,67,16,null,9,89,null,null,82,33,52,24,42,95,31,null,2,99,75,37,null,107,111,null,63,21,null,58,34,null,null,null,69,null,64,null,38,null,100,null,null,45,10,null,null,null,90,116,122,null,92,52,43,35,79,null,66,68,57,9,41};
        TreeNodePrintUtil.displayTree(TreeNode.fromArray(integerArray1));
        object.getLeaves(TreeNode.fromArray(integerArray1));
        for (int i : object.list) {
            System.out.print(" " + i);
        }
        System.out.println();
//        Integer[] integerArray2 = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        Integer[] integerArray2 = {3,5,1,6,71,4,2,null,null,null,null,null,null,9,8};
//        Integer[] integerArray2 = {85,25,40,null,9,null,null,13,null,22,112,112,null,60,89,64,18,91,92,97,null,null,94,90,55,117,33,65,107,111,113,null,44,null,null,18,27,null,106,77,3,null,83,null,null,null,null,52,55,32,null,46,92,74,51,8,32,55,32,null,111,29,null,25,46,63,82,null,15,102,70,61,13,42,30,91,79,2,null,90,null,null,122,62,null,null,66,66,111,63,24,null,76,6,null,33,45,42,69,null,10,21,6,96,79,33,57,null,16,72,122,13,1,29,104,29,29,66,null,41,122,60,5,73,2,16,110,10,39,null,null,122,null,34,88,69,64,38,100,89,109,null,45,10,90,116,122,92,52,null,43,35,79,64,null,66,68,null,57,9,41,null,null,104,34,57,9,null,27,null,121,99,112,null,32,null,null,40,null,null,19,67,16,9,89,82,null,95,52,null,24,42,33,null,31,2,99,75,37,21,58};
        TreeNodePrintUtil.displayTree(TreeNode.fromArray(integerArray2));
        object.list.clear();
        object.getLeaves(TreeNode.fromArray(integerArray2));
        for (int i : object.list) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println(object.leafSimilar(TreeNode.fromArray(integerArray1), TreeNode.fromArray(integerArray2)));
    }
}
