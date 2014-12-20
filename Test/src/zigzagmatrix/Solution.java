package zigzagmatrix;

public class Solution {
	public void printMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)	return;
		boolean lr = true;
		for (int i = 0; i < matrix.length; ++i) {
			if (lr) {
				for (int j = 0; j < matrix[0].length; ++j) {
					System.out.print(matrix[i][j] + "   ");
				}
			}
			else {
				for (int j = matrix[0].length - 1; j >= 0; --j) {
					System.out.print(matrix[i][j] + "   ");
				}
			}
			lr = !lr;
			System.out.println();
		}
	}
	
	public void print1(int[][] matrix) {
		if (matrix == null || matrix.length == 0)	return;
		int i = 0, j = 0;
		while(i < matrix.length && j < matrix[0].length) {
			System.out.print(matrix[i][j] + "   ");
			if (i == matrix.length-1) {
				i = j + 1;
				j = matrix.length-1;
				System.out.println();
			}
			else if (j == 0) {
				j = i + 1;
				i = 0;
				System.out.println();
			}
			else {
				i++;
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] num = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		s.print1(num);
	}
}
