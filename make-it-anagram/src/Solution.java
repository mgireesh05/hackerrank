import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		String s1 = "bugexikjevtubidpulaelsbcqlupwetzyzdvjphn";
		String s2 = "lajoipfecfinxjspxmevqxuqyalhrsxcvgsdxxkacspbchrbvvwnvsdtsrdk";
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);

		int count = 0;
		int i = 0;
		int j = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				i++;
				count++;
			} else if (a1[i] > a2[j]) {
				j++;
				count++;
			} else {
				i++;
				j++;
			}
		}

		if (i < a1.length) {
			count += a1.length - i;
		}

		if (j < a2.length) {
			count += a2.length - j;
		}

		System.out.println(count);
	}
}