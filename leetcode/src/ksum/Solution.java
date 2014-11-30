package ksum;

import java.util.*;
import java.util.Arrays;


public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length < 4) {
            return result;
        }
        Arrays.sort(num);
        kSum(result, num, target, 4, 0, num.length-1, new ArrayList<Integer>());
        return result;
    }
    
    public void kSum(List<List<Integer>> result, int[] num, int target, int k, int left, int right, List<Integer> cur) {
         if(k == 2) {
            while(left < right) {
                int sum = num[left] + num[right];
                if(sum == target) {
                    List<Integer> tmp = new ArrayList<Integer>(cur);
                    tmp.add(num[left]);
                    tmp.add(num[right]);
                    result.add(tmp);
                    left++;
                    right--;
                    while(num[left] == num[left-1]) {
                    	left++;
                    }
                    while(num[right] == num[right+1]) {
                    	right--;
                    }
                }
                else if(sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
            return;
        }
        for(int i = left; i <= right; ++i) {
            if(i == left || num[i] != num[i-1]) {
                cur.add(num[i]);
                kSum(result, num, target-num[i], k-1, i+1, right, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num = {1,0,-1,0,-2,2};
    	List<List<Integer>> result = s.fourSum(num, 0);
    	System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
