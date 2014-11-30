package wordladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
    int count;
    String word;
    Node(int c, String w) {
        word = w;
        count = c;
    }
}
public class Solution {
	public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null || start.equals(end) || dict.size() == 0) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, start));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i = 0; i < node.word.length(); ++i) {
                
                for(char c = 'a'; c <= 'z'; ++c) {
                	char[] chars = node.word.toCharArray();
                    if(chars[i] == c) {
                        continue;
                    }
                    chars[i] = c;
                    String intermediate = new String(chars);
                    if(intermediate.equals(end)) {
                        return node.count;
                    }
                    if(dict.contains(intermediate)) {
                        queue.add(new Node(node.count + 1, intermediate));
                        //dict.remove(intermediate);
                    }
                }
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		s.ladderLength("hot", "dog", dict);
	}
}
