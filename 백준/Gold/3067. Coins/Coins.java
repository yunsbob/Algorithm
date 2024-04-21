import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] coin = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M + 1];
			dp[0] = 1;
			for (int j = 0; j < N; j++) {
				for (int k = coin[j]; k <= M; k++) {
					dp[k] += dp[k - coin[j]];
				}
			}

			sb.append(dp[M]).append('\n');
		}

		System.out.println(sb);
	}
}