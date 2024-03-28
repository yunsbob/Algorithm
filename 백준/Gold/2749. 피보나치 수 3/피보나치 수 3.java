import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		N %= 1_500_000;

		int[] dp = new int[1_500_001];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000;
		}

		System.out.println(dp[(int)N]);
	}
}