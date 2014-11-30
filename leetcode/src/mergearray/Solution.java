package mergearray;

import java.util.Stack;

public class Solution {
	public void merge(int A[], int m, int B[], int n) {
        int last = m + n - 1;
        int a = m-1;
        int b = n-1;
        while(a >= 0 && b >= 0){
            if(A[a] > B[b])
                A[last--] = A[a--];
            else
                A[last--] = B[b--];
        }
	}
	public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int max = 0;
        for(int i = 1; i < height.length; ++i){
            if(stack.isEmpty() || height[i] >= height[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && height[i] < height[stack.peek()]){
                    int left = stack.pop();
                    int length = i - left;
                    if(stack.isEmpty()){
                        length = i;
                    }
                    max = Math.max(length * height[left], max);
                }
            }
        }
        while(!stack.isEmpty()){
            int left = stack.pop();
            int length = height.length - left;
            if(stack.isEmpty()){
                length = height.length;
            }
            max = Math.max(length * height[left], max);
        }
        return max;
    }
	public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        s = s.trim();       // Get rid of leading and trailing whitespaces
        int n = s.length();
        if (n == 0)
            return false;
        boolean isValid = false, isValidExpo = true, isEBefore = false, isExpo = false, isFrac = false, isValidFrac = true;
        int i = 0;
        if(s.length() > 0 && s.charAt(i) == '+' || s.charAt(i) == '-'){
            i++;
        }
        for(; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c == '+' || c == '-'){
                if(!isEBefore){
                    return false;
                }
                isValid = false;
                isEBefore = false;
            }
            else if(c == 'E' || c == 'e'){
                if(isExpo || !isValid){
                    return false;
                }
                isEBefore = true;
                isValidExpo = false;
                isExpo = true;
                isValid = false;
            }
            else if(c == '.'){
                if(isFrac || isExpo){
                    return false;
                }
                isFrac = true;
                if(!isValid){
                    isValidFrac = false;
                }
                
            }
            else if(c >= '0' && c <= '9'){
                isValid = true;
                isValidFrac = true;
                isEBefore = false;
                isValid = true;
            }
            else{
                return false;
            }
        }
        if(!isValidExpo || !isValidFrac || !isValid){
            return false;
        }
        return true;
    }
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "2e0";
		s.isNumber(str);
	}
}
