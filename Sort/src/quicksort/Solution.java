package quicksort;

public class Solution {
	public void quick_sort(int[] num, int left, int right) {
		int pivot = num[((left+right)>>1)];
		int i = left, j = right;
		while(i <= j) {
			while(i <= j && num[i] < pivot) ++i;
			while(i <= j && num[j] > pivot) --j;
			if(i <= j) {
				swap(num, i, j);
				i++;
				j--;
			}
		}
		if(j > left) quick_sort(num, left, j);
		if(i < right) quick_sort(num, i, right);
	}
	
	public int findKth(int[] num, int left, int right, int k) {
		int pivot = num[((left+right)>>1)];
		int i = left, j = right;
		while(i <= j) {
			while(i <= j && num[i] < pivot) ++i;
			while(i <= j && num[j] > pivot) --j;
			if(i <= j) {
				swap(num, i, j);
				i++;
				j--;
			}
		}
		int pos = left;
		for(; pos <= right; ++pos) {
			if(num[pos] == pivot) break;
		}
		if(pos-left+1 == k) return pivot;
		else if(pos-left+1 < k) return findKth(num, pos+1, right, k - pos+left-1);
		else return findKth(num, left, pos-1, k);
	}
	
	public void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] num = {-1, 3,7,1,4,-6,100,-1, -9,};
		Solution s = new Solution();
		for(int i = 1; i <= num.length;++i)
			System.out.println(s.findKth(num, 0, num.length-1, i));
	}
}
