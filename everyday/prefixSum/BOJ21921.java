package everyday.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] pSum = new int[N];

		st = new StringTokenizer(br.readLine());
		pSum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			pSum[i] = Integer.parseInt(st.nextToken()) + pSum[i - 1];
		}

		int max = pSum[X - 1], cnt = 1;
		for (int i = X; i < N; i++) {
			int now = pSum[i] - pSum[i - X];
			if (now > max) {
				max = now;
				cnt = 1;
			} else if (now == max) {
				cnt++;
			}
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
