package leetcodeNZ.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode currentNode = root;
		boolean done = false;
		int index = 0;
		while (!done) {
			System.out.println("this is-------------000----------- index " + index);
			if (currentNode != null) {
				System.out.println("this is-----------1111------------- currentNode.val " + currentNode.val);
				s.push(currentNode);
				System.out.println("this is-----------2222------------- stack " + stackToString(s));
				currentNode = currentNode.left;
				if(currentNode == null) {
					System.out.println("this is-----------4444------------- currentNode.left is null ");
				} else {
					System.out.println("this is-----------5555------------- currentNode.left.val " + currentNode.val);
				}
				
			} else {
				if (s.isEmpty()) {
					done = true;
				} else {
					currentNode = s.pop();
					System.out.println("this is-----------6666------------- currentNode.val " + currentNode.val + " stack " + stackToString(s));
					list.add(currentNode.val);
					currentNode = currentNode.right;
					if(currentNode == null) {
						System.out.println("this is-----------7777------------- currentNode.right is null ");
					} else {
						System.out.println("this is-----------8888------------- currentNode.right.val " + currentNode.val);
					}
				}
			}
			System.out.println("############################################################################################################ " + stackToString(s));
			index++;
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t11 = new TreeNode(11);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t4.left = t8;
		t4.right = t9;
		t5.left = t10;
		t5.right = t11;

		Tree_94_Binary_Tree_Inorder_Traversal obj = new Tree_94_Binary_Tree_Inorder_Traversal();
		List<Integer> list = obj.inorderTraversal(t1);
		System.out.println(list);
	}

}

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {

	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
