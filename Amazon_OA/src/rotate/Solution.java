package rotate;

public class Solution {
	public boolean isRotate(String str1, String str2) {
		if(str1 == null || str2 == null || str1.length() != str2.length() || str1.length() == 0) {
			return false;
		}
		String str = str1 + str1;
		return str.indexOf(str2) == -1 ? false : true;
	}
	
	public boolean isGreyCode(byte b1, byte b2) {
		byte tmp = (byte) (b1 ^ b2);
		if(tmp == 0) {
			return false;
		}
		tmp = (byte)(tmp & (tmp - 1));
		return tmp == 0 ? true : false;
	}
	
	public String removeVolve(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		String table = "aeiouAEIOU";
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < s.length(); ++i) {
			if(table.indexOf(s.charAt(i)) != -1) {
				continue;
			}
			result.append(s.charAt(i));
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		assert s.isRotate("abc", "bca") == true;
		assert s.isRotate("abc", "bac") == false;
		assert s.isRotate("abc", "abc") == true;
		
		
		assert s.isGreyCode((byte)001, (byte)000) == true;
		assert s.isGreyCode((byte)2, (byte)000) == true;
		assert s.isGreyCode((byte)4, (byte)0) == true;
		assert s.isGreyCode((byte)7, (byte)6) == true;
		assert s.isGreyCode((byte)13, (byte)4) == false;
		assert s.isGreyCode((byte)3, (byte)1) == true;
		assert s.isGreyCode((byte)11, (byte)1) == false;
		
		assert s.removeVolve("aeiou").equals("");
		assert s.removeVolve("aeibbbbou").equals("bbbb");
		assert s.removeVolve("zde").equals("zd");
		assert s.removeVolve("AAaeiott").equals("tt");
		assert s.removeVolve("ttewaEI").equals("ttw");
		assert s.removeVolve("AELLIOU").equals("LL");
	}
}
