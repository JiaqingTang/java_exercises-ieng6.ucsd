package iterator;

import java.util.Stack;

class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
}

public class Solution {
	TreeNode next;
    Stack<TreeNode> stack;
    public Solution(TreeNode root) {
        // write your code here
        stack = new Stack<TreeNode>();
        next = root;
        while (next.left != null) {
            stack.push(next);
            next = next.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return next != null;
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode result = next;
        if (next.right != null) {
            next = next.right;
            while (next.left != null) {
                stack.push(next);
                next = next.left;
            }
        }
        else {
            if (stack.isEmpty())    next = null;
            else next = stack.pop();
        }
        return result;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(-1);
    	Solution s = new Solution(root);
    	while (s.hasNext())
    		System.out.print(s.next().val);
    	
    }
}
