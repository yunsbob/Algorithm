package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String N = br.readLine();
		int sum = 0;
		int[] arr = new int[10];
		for (int i = 0; i < N.length(); i++) {
			sum += N.charAt(i) - '0';
			arr[N.charAt(i) - '0']++;
		}

		if (arr[0] == 0 || sum % 3 != 0) System.out.println(-1);
		else {
			for (int i = 9; i >= 0; i--) {
				while (arr[i] != 0) {
					sb.append(i);
					arr[i]--;
				}
			}
		}

		System.out.println(sb);
	}
}
