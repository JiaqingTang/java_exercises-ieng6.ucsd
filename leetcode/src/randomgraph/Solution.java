package randomgraph;

import java.util.HashMap;

class RandomListNode {
	    int label;
    RandomListNode next, random;
	 RandomListNode(int x) { this.label = x; }
	 }
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return head;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = head, pre = dummy;
        while(cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            pre.next = node;
            pre = node;
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(cur);
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		RandomListNode head = new RandomListNode(-1);
		RandomListNode copy = s.copyRandomList(head);
		System.out.println(copy.label);
	}
}
