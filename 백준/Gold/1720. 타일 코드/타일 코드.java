import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[31];

		dp[0] = dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] * 2;
		}

		if (N % 2 == 0) {
			System.out.println((dp[N] + dp[N / 2] + dp[N / 2 - 1] * 2) / 2);
		} else {
			System.out.println((dp[N] + dp[N / 2]) / 2);
		}
	}
}