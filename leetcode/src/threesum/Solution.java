package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length < 3){
            return result;
        }
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; ++i){
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(num[i]);
            twoSum(result, cur, num, i + 1, -num[i]);
        }
        return result;
    }
    
    public void twoSum(List<List<Integer>> result, List<Integer> cur, int[] num, int index, int target){
        for(int i = index; i < num.length - 1; i ++){
            cur.add(num[index]);
            dfs(result, cur, num, index+1, target - num[index]);
            cur.remove(cur.size() -1);
        }
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> cur, int[] num, int index, int target){
        for(int i = index; i < num.length; ++i){
            if(num[i] == target){
            	List<Integer> tmp = new ArrayList<Integer>(cur);
                tmp.add(num[i]);
                result.add(new ArrayList<Integer>(tmp));
                return;
            }
        }
    }
    
    public static void main(String args[]){
    	Solution s = new Solution();
    	int[] num = {-1, 0, 1, 2, -1, -4};
    	System.out.print(s.threeSum(num));
    	
    }
}
