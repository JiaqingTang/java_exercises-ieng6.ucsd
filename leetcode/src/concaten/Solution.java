package concaten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(L == null || L.length == 0){
            return result;
        }
        HashMap<String, Integer> needtofind = new HashMap<String, Integer>();
        
        for(String str : L){
            if(needtofind.containsKey(str)){
                needtofind.put(str, needtofind.get(str) + 1);
            }
            else{
                needtofind.put(str, 1);
            }
        }
        int step = L[0].length();
        int start = 0, count = 0;
        for(int i = 0; i < step; ++i){
            start = i;
            count = 0;
            HashMap<String, Integer> hasfound = new HashMap<String, Integer>();
            for(int j = i; j <= S.length() - step; j += step){
                String str = S.substring(j, j + step);
                if(needtofind.containsKey(str)){
                    if(hasfound.containsKey(str)){
                        hasfound.put(str, hasfound.get(str) + 1);
                    }
                    else{
                        hasfound.put(str, 1);
                    }
                    if(hasfound.get(str) <= needtofind.get(str)){
                        count++;
                    }
                    if(count >= L.length){
                        String tmp = S.substring(start, start + step);
                        while(!needtofind.containsKey(tmp) || needtofind.get(tmp) < hasfound.get(tmp)){
                            if(needtofind.containsKey(tmp)){
                                hasfound.put(tmp, hasfound.get(tmp) - 1);
                            }
                            start += step;
                            tmp = S.substring(start, start + step);
                        }
                    }
                    if(count >= L.length){
                        result.add(start);
                        start++;
                    }
                }
                else{
                    start = j + step;
                    hasfound.clear();
                    count = 0;
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		String[] L = {"a","b"};
		s.findSubstring("abababab", L);
	}
}
