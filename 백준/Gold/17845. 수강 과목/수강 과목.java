import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] study = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			study[i][0] = Integer.parseInt(st.nextToken());
			study[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		for (int i = 0; i < K; i++) {
			int I = study[i][0];
			int T = study[i][1];

			for (int j = N; j >= 0; j--) {
				if (T > j)
					break;

				dp[j] = Math.max(dp[j], dp[j - T] + I);
			}
		}

		System.out.println(dp[N]);
	}
}