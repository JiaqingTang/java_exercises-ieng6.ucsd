package findmin;

public class Solution {
	public int findMin(int[] num){
		int left = 0;
		int right = num.length - 1;
		while(left < right){
			if(left + 1 == right){
				return num[right];
			}
			int mid = (left + right) / 2;
			if(num[mid] == num[left] && num[left] == num[right]){
				left++;
			}
			else if(num[mid] >= num[left]){
				left = mid;
			}
			else{
				right = mid;
			}
		}
		return right;
	}
	public static void main(String[] args){
		int[] num = {1,0,1,1,1,1,1};
		Solution s = new Solution();
		System.out.println(s.findMin(num));
	}
}
