package com.mgireesh;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// int k = in.nextInt();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = in.nextInt();
		// }
		in.close();

		int[] arr = { 145, 161, 11, 116, 64, 85, 158, 167, 125, 14, 104, 34, 15, 119, 51, 118, 63, 188, 166, 113, 114,
				194, 126, 53, 133, 109, 48, 40, 32, 52, 108, 62, 153, 105, 44, 129, 89, 186, 45, 73, 115, 66, 130, 56,
				141, 197, 36, 192, 107, 24, 22, 152, 81, 137, 111, 101, 100, 144, 9, 16, 31, 154, 198, 159, 70, 179, 50,
				172, 39, 155, 79, 37, 87, 69, 121, 134, 93, 7, 5, 17, 110, 122, 96, 103, 177, 193, 95, 33, 164, 71, 143,
				82, 77, 75, 162, 191, 102, 19, 91, 94, 157, 184, 35, 23, 99, 180, 182, 6, 59, 176, 146, 13, 165, 135, 3,
				4, 195, 112, 189, 30, 27, 168, 123, 41, 57, 136, 190, 29, 132, 76, 38, 1, 10, 83, 124, 163, 20, 117,
				178, 2, 42, 84, 12, 171, 67, 43, 58, 183, 8, 138, 68, 149, 131, 47, 74, 60, 80, 90, 78, 160, 169, 21,
				61, 187, 92, 25, 181, 147, 88, 106, 55, 97, 150, 120, 128, 139, 140, 175, 26, 127, 173, 185, 65, 196,
				86, 28, 98, 54, 142, 18, 151, 46, 49, 170, 174, 156, 148, 72 };
		int n = 198;
		int k = 162;

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			maxHeap.offer(arr[i]);
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], i);
		}

		int count = Math.min(k, arr.length);
		for (int i = 0; i < count; i++) {
			int max = maxHeap.remove();
			int maxIdx = map.get(max);
			if (max == arr[i]) {
				count++;
				continue;
			}

			map.put(arr[i], maxIdx);
			map.put(max, i);
			arr[maxIdx] = arr[i];
			arr[i] = max;
		}

		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}

}
