import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] dp;
	private static List<Study> list = new ArrayList<>();

	private static class Study {
		int K, S;

		public Study(int K, int S) {
			this.K = K;
			this.S = S;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			list.add(new Study(K, S));
		}

		dp = new int[N][T + 1];

		System.out.println(knapsack(N - 1, T));
	}

	private static int knapsack(int idx, int time) {
		if (idx < 0)
			return 0;

		if (dp[idx][time] != 0)
			return dp[idx][time];

		Study now = list.get(idx);

		if (time - now.K < 0)
			return dp[idx][time] = knapsack(idx - 1, time);
		else
			return dp[idx][time] = Math.max(knapsack(idx - 1, time), knapsack(idx - 1, time - now.K) + now.S);
	}
}