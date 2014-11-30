package reverse;

public class Solution {
	public String reverseString(String str) {
		if(str == null || str.length() == 0) {
			return str;
		}
		char[] chars = str.toCharArray();
		for(int i = 0; i < (chars.length >> 1); ++i) {
			char c = chars[i];
			chars[i] = chars[chars.length - 1 - i];
			chars[chars.length - 1 - i] = c;
		}
		return new String(chars);
	}
	
	public static void main(String[] args) {
		String s = "";
		Solution solu = new Solution();
		System.out.println(solu.reverseString(s).equals(""));
	}
}
 