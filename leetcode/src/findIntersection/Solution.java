package findIntersection;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> findInterSection(int[] m, int[] n) {
		if (m == null || n == null || m.length == 0 || n.length == 0)	return null;
		int i = 0, j = 0;
		List<Integer> result = new ArrayList<Integer>();
		while (i < m.length && j < n.length) {
			if (m[i] == n[j]) {
				result.add(m[i]);
				i++;
				j++;
			}
			else if (m[i] < n[j])	i++;
			else	j ++;
		}
		return result;
	}
	
	public static void main(String[] main) {
		Solution s = new Solution();
		int[] m = {1,2,3,4,5,6};
		int[] n = {3,5,7,8};
		System.out.println(s.findInterSection(m, n));
	}
}
