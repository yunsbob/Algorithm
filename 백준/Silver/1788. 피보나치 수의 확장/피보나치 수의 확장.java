import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if (N < 0) {
			System.out.println(N % 2 == 0 ? -1 : 1);
			N *= -1;
		} else if (N == 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}

		int[] dp = new int[1_000_001];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
		}

		System.out.println(dp[N]);
	}
}