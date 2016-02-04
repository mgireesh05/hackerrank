import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		File file = new File("/Users/gkumar/Documents/github/hackerrank/missing-numbers/src/input.txt");

		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = in.nextInt();
		Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			int count = 0;
			if (mapA.containsKey(num)) {
				count = mapA.get(num);
			}
			mapA.put(num, count + 1);
		}
		int m = in.nextInt();
		Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
		for (int i = 0; i < m; i++) {
			int num = in.nextInt();
			int count = 0;
			if (mapB.containsKey(num)) {
				count = mapB.get(num);
			}
			mapB.put(num, count + 1);
		}

		SortedSet<Integer> out = new TreeSet<Integer>();
		for (Map.Entry<Integer, Integer> entry : mapB.entrySet()) {
			Integer key = entry.getKey();
			if (mapA.containsKey(key)) {
				if (!mapA.get(key).equals(entry.getValue())) {
					out.add(key);
				}
			} else {
				out.add(key);
			}
		}

		for (Integer i : out) {
			System.out.printf("%d ", i);
		}
		in.close();
	}
}