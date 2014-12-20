package findtarget;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	TreeNode left, right, parents;
	int val;
	TreeNode(int v) {
		val = v;
	}
}

public class Solution {
	public TreeNode getTarget(TreeNode root, int target) {
		if (root == null)	return null;
		if (root.val == target)	return root;
		if (root.val < target)	return getTarget(root.right, target);
		return getTarget(root.left, target);
	}
	
	public TreeNode getPre(TreeNode root, int target) {
		if (root == null)	return null;
		TreeNode leftmost = root;
		while (leftmost.left != null)	leftmost = leftmost.left;
		if (leftmost.val == target)	return null;
		TreeNode successor = getSuccessor(leftmost);
		while (successor != null) {
			if (successor.val == target) return leftmost;
			leftmost = successor;
			successor = getSuccessor(leftmost);
		}
		return null;
	}
	
	public TreeNode getSuccessor(TreeNode node) {
		if (node == null)	return null;
		if (node.right != null) {
			node = node.right;
			while (node.left != null)	node = node.left;
			return node;
		}
		else {
			while (node.parents != null && node.parents.right == node)	node = node.parents;
			return node.parents;
		}
	}
	
	public void printLeft(TreeNode root) {
		if (root == null)	return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.peek();
			System.out.println(cur.val);
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				cur = queue.poll();
				if (cur.left != null)	queue.add(cur.left);
				if (cur.right != null)	queue.add(cur.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.parents = root;
		root.right = new TreeNode(5);
		root.right.parents = root;
		System.out.println(s.getPre(root, 5).val);
		s.printLeft(root);
	}
	
}
