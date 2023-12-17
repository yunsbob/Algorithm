package everyday.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ11048 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int a = dp[i - 1][j];
				int b = dp[i][j - 1];
				int c = dp[i - 1][j - 1];

				if (a >= b && a >= c) dp[i][j] += dp[i - 1][j];
				else if (b >= a && b >= c) dp[i][j] += dp[i][j - 1];
				else dp[i][j] += dp[i - 1][j - 1];
			}
		}

		System.out.println(dp[N][M]);
	}
}