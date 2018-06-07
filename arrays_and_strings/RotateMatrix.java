import java.util.*;

class RotateMatrix {
	private static boolean rotateMatrix(int[][] mat) {
		if (mat.length == 0 || mat.length != mat[0].length) {
			return false;
		}

		int n = mat.length;

		for (int i = 0; i < (n-1)/2; i++) {
			for (int j = 0; j < (n-1)/2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][n-i-1];
				mat[j][n-i-1] = mat[n-i-1][n-j-1];
				mat[n-i-1][n-j-1] = mat[n-j-1][i];
				mat[n-j-1][i] = temp;
			}
			int temp = mat[i][(n-1)/2];
			mat[i][(n-1)/2] = mat[(n-1)/2][n-i-1];
			mat[(n-1)/2][n-i-1] = mat[n-i-1][(n-1)/2];
			mat[n-i-1][(n-1)/2] = mat[(n-1)/2][i];
			mat[(n-1)/2][i] = temp;

		}
		return true;
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		int[][] mat1 = {};
		System.out.println(rotateMatrix(mat1));
		int[][] mat2 = {{1, 2}};
		System.out.println(rotateMatrix(mat2));
		int[][] mat3 = {{1}, {2}};
		System.out.println(rotateMatrix(mat3));
		int[][] mat4 = {{1}};
		printMatrix(mat4);
		System.out.println(rotateMatrix(mat4));
		printMatrix(mat4);
		int[][] mat5 = {{1, 2},{3, 4}};
		printMatrix(mat5);
		System.out.println(rotateMatrix(mat5));
		printMatrix(mat5);
		int[][] mat6 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		printMatrix(mat6);
		System.out.println(rotateMatrix(mat6));
		printMatrix(mat6);
	}
}
