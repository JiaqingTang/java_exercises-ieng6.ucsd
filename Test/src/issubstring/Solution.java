package issubstring;

public class Solution {
	public boolean isSubstring(String s, String p) {
		if (s == null || p == null || s.length() < p.length())	return false;
		int ps = 0, pp = 0;
		while (ps < s.length() && pp < p.length()) {
			if (s.charAt(ps) == p.charAt(pp)) {
				ps++;
				pp++;
			}
			else {
				ps++;
			}
		}
		if (pp == p.length())	return true;
		return false;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isSubstring("abcdedf", "bdf"));
		System.out.println(s.isSubstring("abcdedf", "abcdedf"));
		System.out.println(s.isSubstring("abcdedf", "a"));
		System.out.println(s.isSubstring("abcdedf", "z"));
		System.out.println(s.isSubstring("z", "z"));
		System.out.println(s.isSubstring("zt", "z"));
		System.out.println(s.isSubstring("zt", "ztt"));
	}
}
