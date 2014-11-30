package continusSum;
import java.util.*;
public class Solution {
	public List<List<Integer>> findCSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		if (nums == null || nums.length == 0) return res;
		int[] table = new int[nums.length+1];
		for(int i = 0; i < nums.length; ++i) {
			table[i+1] = table[i] + nums[i];
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < table.length; ++i) {
			if (map.containsKey(table[i])) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(map.get(table[i]));
				tmp.add(i-1);
				res.add(tmp);
			}
			map.put(table[i] + target, i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] num = {-1, 4, -1, 0, -2, -3, 7};
		System.out.println(s.findCSum(num,3));
	}
}
