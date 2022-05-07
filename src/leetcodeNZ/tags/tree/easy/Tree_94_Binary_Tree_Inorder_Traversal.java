package leetcodeNZ.tags.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcodeNZ.model.TreeNode;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

	Example:
	
	Input: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3
	
	Output: [1,3,2]
	Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class Tree_94_Binary_Tree_Inorder_Traversal {
	
	private String stackToString(Stack<TreeNode> s) {
		String result = "";
		
		for(int i = 0; i < s.size(); i++) {
			TreeNode node = s.get(i);
			result += node.val + " ";
		}
		return result;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode currentNode = root;
		boolean done = false;
		while (!done) {
			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if (s.isEmpty()) {
					done = true;
				} else {
					currentNode = s.pop();
					list.add(currentNode.val);
					currentNode = currentNode.right;
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		int[] nums = {-10,-3,0,5,9};
		Tree_108_convert_sorted_array_to_binary_search_tree obj_108 = new Tree_108_convert_sorted_array_to_binary_search_tree();
		TreeNode node = obj_108.arrayToBinaryTree(nums);

		Tree_94_Binary_Tree_Inorder_Traversal obj_94 = new Tree_94_Binary_Tree_Inorder_Traversal();
		List<Integer> list = obj_94.inorderTraversal(node);
		System.out.println(list);
	}

}
