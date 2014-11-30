package wordbreak;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || dict == null){
            return false;
        }
        return dfs(s, dict);
    }
    
    public boolean dfs(String s, Set<String> dict){
        int len = s.length();
        for(int i = 1; i <= len; ++i){
            if(dict.contains(s.substring(0, i)) && (dfs(s.substring(i), dict) || i == len)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
    	Set<String> set = new HashSet<String>();
    	set.add("a");
    	set.add("aa");
    	Solution s = new Solution();
    	System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", set));
    }
}
