import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		int M = Integer.parseInt(br.readLine());
		int res = 1, prev = 0;
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(br.readLine());
			res *= dp[now - prev - 1];
			prev = now;
		}

		System.out.println(res * dp[N - prev]);
	}
}