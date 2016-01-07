package com.mgireesh;

import java.util.Scanner;

public class Solution {

	private long minDTime(int n, int[] dtimes, long[][] results, int s, int e, int depth) {
		if (results[s][e] != -1) {
			return results[s][e];
		}

		if (s == e) {
			results[s][e] = dtimes[s] * depth;
			return results[s][e];
		}

		long val1 = minDTime(n, dtimes, results, s + 1, e, depth + 1);
		long val2 = minDTime(n, dtimes, results, s, e - 1, depth + 1);

		long val = Math.min(val1 + (dtimes[s] * depth), val2 + (dtimes[e] * depth));

		results[s][e] = val;
		return val;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);

		// int n = sc.nextInt();
		// if (n <= 0) {
		// System.out.println(0);
		// return;
		// }
		// int[] dtimes = new int[n];
		// for (int i = 0; i < n; i++) {
		// dtimes[i] = sc.nextInt();
		// }

		int n = 5;
		int[] dtimes = { 5, 4, 3, 2, 1 };
		long[][] results = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				results[i][j] = -1;
			}
		}

		Solution s = new Solution();
		long res = s.minDTime(n, dtimes, results, 0, n - 1, 1);
		System.out.println(res);

		return;
	}
}
