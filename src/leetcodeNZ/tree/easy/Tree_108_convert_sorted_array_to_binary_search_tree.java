/**
 * 
 */
package leetcodeNZ.tree.easy;

import leetcodeNZ.model.TreeNode;
import leetcodeNZ.util.TreeNodePrintUtil;

/*
 * 	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

	Example:

	Given the sorted array: [-10,-3,0,5,9],

	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

	      0
	     / \
	   -3   9
	   /   /
	 -10  5
 */

/**
 * @author simonhan 16 Aug 2020
 */
public class Tree_108_convert_sorted_array_to_binary_search_tree {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = new TreeNode(nums[0]);
		for(int i = 1; i < nums.length; i++) {
			createBST(root, nums[i]);
		}
		return root;
	}
	
	private void createBST(TreeNode node, int insetedNodeVal) {
		if (insetedNodeVal < node.val) {
			if (node.left == null) {
				node.left = new TreeNode(insetedNodeVal);
			} else {
				createBST(node.left, insetedNodeVal);
			}
		} else {
			if (node.right == null) {
				node.right = new TreeNode(insetedNodeVal);
			} else {
				createBST(node.right, insetedNodeVal);
			}
		}
	}
	
	public TreeNode arrayToBinaryTree(int[] nums) {
		if (nums.length <= 0) return null;
		return constructBinaryTree(nums, 0, nums.length - 1);
	}
	
	private TreeNode constructBinaryTree(int[] nums, int left, int right) {
		if (right < left) return null;
		int middlePoint = left + (right - left) / 2;
		TreeNode middleTreeNode = new TreeNode(nums[middlePoint]);
		middleTreeNode.left = constructBinaryTree(nums, left, middlePoint - 1);
		middleTreeNode.right = constructBinaryTree(nums, middlePoint + 1, right);
		TreeNodePrintUtil.displayTree(middleTreeNode);
		return middleTreeNode;
	}
	
	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		Tree_108_convert_sorted_array_to_binary_search_tree obj = new Tree_108_convert_sorted_array_to_binary_search_tree();
		TreeNode node = obj.arrayToBinaryTree(nums);
		TreeNodePrintUtil.displayTree(node);
	}
}
