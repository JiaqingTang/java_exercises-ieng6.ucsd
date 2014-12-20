package peak;

public class Solution {
	public int findPeak(int[] A) {
		if (A == null || A.length == 0) return -1;
        int left = 0, right = A.length-1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid == left)    return A[left] < A[right] ? right : left;
            if (A[mid] >= A[mid-1] && A[mid] >= A[mid+1])  return mid;
            if (A[mid] < A[mid-1])  right = mid - 1;
            else    left = mid + 1;
        }
        return A[left] < A[right] ? right : left;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] n = {10, 20, 15, 2, 23, 90, 67};
		System.out.println(s.findPeak(n));
		int[] nn = {10, 20, 30, 40, 50};
		System.out.println(s.findPeak(nn));
		int[] nnn = {100, 80, 60, 50, 20};
		System.out.println(s.findPeak(nnn));
	}
}
