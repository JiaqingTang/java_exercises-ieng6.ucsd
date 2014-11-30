package singlenumber;
public class Solution {
    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        for(int a : A){
            int bit = 0;
            while(bit < 32){
            	if(((1 << bit) & a) != 0)
            		bits[bit] += 1;
                bit++;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; ++i){
            int bit = bits[i] % 3;
            result |= (bit << i);
        }
        return result;
    }
    
    public int singleNumber2(int[] A) {
        int[] bits = new int[32];
        for(int num : A) {
            int digit = 0;
            while(digit < 32) {
                if(((1 << digit) & num) != 0) {
                    bits[digit]++;
                }
                digit++;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; ++i) {
            bits[i] %= 3;
            result |= (bits[i] * (1 << i));
        }
        return result;
    }
    public static void main(String[] args){
    	int[] num = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
    	int[] num1 = {2,2,2,3};
    	Solution s = new Solution();
    	System.out.println(s.singleNumber2(num1));
    }
}