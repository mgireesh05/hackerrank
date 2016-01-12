
public class Solution {

	private static boolean match(int[][] G, int i, int j, int[][] P, int r, int c) {
		for (int k = i, m = 0; m < r; k++, m++) {
			for (int l = j, n = 0; n < c; l++, n++) {
				if (G[k][l] != P[m][n]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int R = 4;
		int C = 6;
		int[][] G = { { 1, 2, 3, 4, 1, 2 }, { 5, 6, 1, 2, 1, 2 }, { 1, 2, 3, 6, 3, 4 }, { 7, 8, 1, 2, 8, 8 } };

		int r = 2;
		int c = 2;
		int[][] P = { { 1, 2 }, { 3, 4 } };

		boolean found = false;
		for (int i = 0; i < R; i++) {
			found = false;
			for (int j = 0; j < C; j++) {
				if (G[i][j] == P[0][0] && i + r <= R && j + c <= C) {
					if (match(G, i, j, P, r, c) == true) {
						found = true;
						break;
					}
				}
			}

			if (found) {
				break;
			}
		}

		if (found) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
