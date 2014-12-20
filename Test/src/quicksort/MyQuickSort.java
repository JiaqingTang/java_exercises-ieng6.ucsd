package quicksort;

public class MyQuickSort {
	public void quickSort(int[] A, int left, int right) {
		int i = left;
		int j = right;
		int pivot = A[(left + right) >> 1];
		while (i <= j) {
			while (A[i] < pivot) {
				i++;
			}
			while (A[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(A, i++, j--);
			}
		}
		if (i < right) {
			quickSort(A, i, right);
		}
		if (j > left) {
			quickSort(A, left, j);
		}
	}
	
	public void swap (int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] A = {8, 2, 4,5, 6,4,-4};
		MyQuickSort test = new MyQuickSort();
		test.quickSort(A, 0, A.length-1);
		for(int a : A) {
			System.out.print(a+" ");
		}
	}
}
