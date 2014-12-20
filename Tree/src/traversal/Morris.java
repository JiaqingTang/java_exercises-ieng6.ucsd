package traversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	TreeNode(int v) {
		val = v;
	}
	int val;
	TreeNode left, right;
}

public class Morris {
	public List<Integer> inorder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)	return result;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				result.add(cur.val);
				cur = cur.right;
			}
			else {
				TreeNode pre = cur.left;
				while(pre.right != null && pre.right != cur)	pre = pre.right;
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				}
				else {
					pre.right = null;
					result.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Morris s = new Morris();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(5);
		root.right.left.right = new TreeNode(6);
		System.out.println(s.inorder(root));
	}
}
