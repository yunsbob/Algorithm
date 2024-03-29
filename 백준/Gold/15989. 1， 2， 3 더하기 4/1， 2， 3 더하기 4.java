import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[10000][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = 1;
			}
		}

		for (int i = 3; i < 10000; i++) {
			dp[i][0] = dp[i - 1][0];
			dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
			dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
		}

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(Arrays.stream(dp[n - 1]).sum()).append('\n');
		}

		System.out.println(sb);
	}
}