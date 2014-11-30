package aB;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> findPerm(String str) {
		List<String> result = new ArrayList<String>();
		if(str == null || str.length() == 0) {
			return result;
		}
		dfs(result, str, new StringBuilder(), 0);
		return result;
	}
	
	public void dfs(List<String> result, String str, StringBuilder cur, int index) {
		if(index >= str.length()) {
			result.add(cur.toString());
			return;
		}
		
		char c = str.charAt(index);
		if(isNum(c)) {
			cur.append(c);
			dfs(result, str, cur, index+1);
			cur.deleteCharAt(cur.length()-1);
		}
		else {
			cur.append(c);
			dfs(result, str, cur, index+1);
			cur.deleteCharAt(cur.length()-1);
			cur.append(Character.toUpperCase(c));
			dfs(result, str, cur, index+1);
			cur.deleteCharAt(cur.length()-1);
		}
	}
	
	public boolean isNum(char c) {
		if(c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findPerm("0ab"));
	}
}
