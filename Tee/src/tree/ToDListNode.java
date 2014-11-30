package tree;

public class ToDListNode {
	class pair{
		pair(){
			head = new TreeNode(1);
			tail = new TreeNode(1);
		}
		TreeNode head;
		TreeNode tail;
		
	}
	public TreeNode convertList(TreeNode node){
		if(node == null){
			return null;
		}
		pair result = new pair();
		convert(node, result);
		return result.head;
	}
	
	public void convert(TreeNode node, pair result){
		if(node == null){
			return;
		}
		convert(node.left, result);
		node.left = result.tail;
		if(result.head == null){
			result.head = node;
		}
		else{
			result.tail.right = node;
		}
		TreeNode right = node.right;
		result.tail = node;
		node.right = null;
		convert(right, result);
	}
}
