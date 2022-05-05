/**
 * 
 */
package leetcodeNZ.model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author simonhan
 * 16 Aug 2020
 */
//Definition for a binary tree node.
public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(Integer val) {
		this.val = val;
	}

	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode fromArray(Integer[] tree) {
		if (tree == null || tree.length == 0) return null;
		TreeNode root = new TreeNode(tree[0]);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int i = 1;
		while (i < tree.length) {
			TreeNode node = q.peek();
			if (node != null) {
				node.left = tree[i] == null ? null : new TreeNode(tree[i]); i++;
				node.right = tree[i] == null ? null : new TreeNode(tree[i]); i++;
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}
			q.remove(node);
		}
		return root;
	}
}
