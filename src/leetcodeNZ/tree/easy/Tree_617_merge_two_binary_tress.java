package leetcodeNZ.tree.easy;

import java.util.HashMap;
import java.util.Map;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 *             Input:
 *             Tree 1                     Tree 2
 *                1                         2
 *               / \                       / \
 *              3   2                     1   3
 *             /                           \   \
 *             5                            4   7
 *
 *             Output:
 *             Merged tree:
 *                 3
 *                / \
 *               4   5
 *              / \   \
 *             5   4   7
 */

/**
 * @author Simon-the-coder
 * @date 17/08/20 9:43 am
 */
public class Tree_617_merge_two_binary_tress {

    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return null;
        int newValue = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val);

        TreeNode newNode = new TreeNode(newValue);
        newNode.left = mergeTrees(node1 == null ? null : node1.left, node2 == null ? null : node2.left);
        newNode.right = mergeTrees(node1 == null ? null : node1.right, node2 == null ? null : node2.right);
        return newNode;
    }

    public static void main(String[] args) {
        TreeNode first5 = new TreeNode(5, null, null);
        TreeNode first3 = new TreeNode(3, first5, null);
        TreeNode first2 = new TreeNode(2, null, null);
        TreeNode first1 = new TreeNode(1, first3, first2);
        TreeNodePrintUtil.displayTree(first1);
        TreeNode second4 = new TreeNode(4, null, null);
        TreeNode second7 = new TreeNode(7, null, null);
        TreeNode second1 = new TreeNode(1, null, second4);
        TreeNode second3 = new TreeNode(3, null, second7);
        TreeNode second2 = new TreeNode(2, second1, second3);
        TreeNodePrintUtil.displayTree(second2);
        Tree_617_merge_two_binary_tress object = new Tree_617_merge_two_binary_tress();
        TreeNodePrintUtil.displayTree(object.mergeTrees(first1, second2));
    }
}
