import java.util.*;

class ZeroMatrix {
	private static boolean zeroMatrix(int[][] mat) {
		if (mat.length == 0 | mat[0].length == 0) {
			return false;
		}

		boolean clear_row = false;
		boolean clear_col = false;

		for (int i = 0; i < mat.length; i++) {
			if (mat[i][0] == 0) {
				clear_col = true;
				break;
			}
		}

		for (int j = 0; j < mat[0].length; j++) {
			if (mat[0][j] == 0) {
				clear_row = true;
				break;
			}
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < mat.length; i++) {
			if (mat[i][0] == 0) {
				for (int j = 1; j < mat[0].length; j++) {
					mat[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < mat[0].length; j++) {
			if (mat[0][j] == 0) {
				for (int i = 1; i < mat.length; i++) {
					mat[i][j] = 0;
				}
			}
		}

		if (clear_col) {
			for (int i = 0; i < mat.length; i++) {
				mat[i][0] = 0;
			}
		}

		if (clear_row) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[0][j] = 0;
			}
		}

		return true;
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mat1 = {{}};
		System.out.println(zeroMatrix(mat1));
		int[][] mat2 = {{1}};
		printMatrix(mat2);
		System.out.println(zeroMatrix(mat2));
		printMatrix(mat2);

		int[][] mat3 = {{1, 0},{1, 1}};
		printMatrix(mat3);
		System.out.println(zeroMatrix(mat3));
		printMatrix(mat3);

		int[][] mat4 = {{1, 1, 1, 1},{1, 0, 1, 1},{1, 1, 1, 1}};
		printMatrix(mat4);
		System.out.println(zeroMatrix(mat4));
		printMatrix(mat4);

		int[][] mat5 = {{0, 1, 1},{1, 1, 1},{1, 0, 1},{1, 1, 1}};
		printMatrix(mat5);
		System.out.println(zeroMatrix(mat5));
		printMatrix(mat5);

		int[][] mat6 = {{0, 1, 1, 1},{1, 1, 1, 1},{1, 1, 0, 1},{1, 1, 1, 1}};
		printMatrix(mat6);
		System.out.println(zeroMatrix(mat6));
		printMatrix(mat6);
	}
}
