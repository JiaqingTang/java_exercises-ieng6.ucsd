package compresstree;

public class Solution {
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flat(root, null);
    }
    
    public void flat(TreeNode root, TreeNode pre){
        if (root == null) {
            return;
        }
        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }
        TreeNode right = root.right;
        flat(root.left, root);
        flat(right, root.left);
    }
    
    public static void main (String[] args) {
    	Solution s = new Solution();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	s.flatten(root);
    }
}
