package printlist;

class ListNode {
	int val;
	ListNode next;
	ListNode(int v) {
		val = v;
	}
}

public class Solution {
	public void printList(ListNode node) {
		if (node == null)	return;
		printList(node.next);
		System.out.println(node.val + " ");
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		s.printList(head);
	}
}
