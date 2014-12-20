package knapsack;

import java.util.Arrays;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
//    	int[][] max = new int[A.length+1][m+1];
//        Arrays.sort(A);
//        for (int i = 1; i <= A.length; ++i) {
//            for (int j = 1; j <= m; ++j) {
//                if (j >= A[i-1])   max[i][j] = Math.max(max[i-1][j], max[i-1][j-A[i-1]] + A[i-1]);
//                else    max[i][j] = max[i-1][j];
//            }
//        }
//        return max[A.length][m];
    	// write your code here
        int[] max = new int[m+1];
        Arrays.sort(A);
        for (int i = A.length; i > 0; --i) {
            for (int j = m; j > 0; --j) {
                if (j >= A[i-1])   max[j] = Math.max(max[j], max[j-A[i-1]] + A[i-1]);
                else    max[j] = max[j];
            }
        }
        return max[m];
    	
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num = {16,16,3,5};
    	s.backPack(34, num);
    }
}
