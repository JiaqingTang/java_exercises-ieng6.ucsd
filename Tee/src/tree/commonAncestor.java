package tree;

public class commonAncestor {
	public TreeNode findcommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		TreeNode l = findcommonAncestor(root.left, p, q);
		TreeNode r = findcommonAncestor(root.right, p, q);
		if(l != null && r != null)
			return root;
		return null;
		
			
	}

}
