import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] arr = { -20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854 };
		int N = 10;

		Arrays.sort(arr);

		int min = Math.abs(arr[0] - arr[1]);
		for (int i = 0, j = 1; j < N; i++, j++) {
			min = Math.min(min, Math.abs(arr[i] - arr[j]));
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0, j = 1; j < N; i++, j++) {
			int temp = Math.abs(arr[i] - arr[j]);
			if (temp == min) {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(arr[i]);
				l.add(arr[j]);
				list.add(l);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).get(0) + " ");
			sb.append(list.get(i).get(1) + " ");
		}
		System.out.println(sb.toString());
	}
}