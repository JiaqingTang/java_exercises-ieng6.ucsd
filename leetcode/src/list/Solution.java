package list;
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}
public class Solution {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head->next = new ListNode(2);
		System.out.println(head->next->val);
	}

}
