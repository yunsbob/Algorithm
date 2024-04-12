import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[1100];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1001;
		}

		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] == 1001)
				break;

			for (int j = 1; j <= arr[i]; j++) {
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}

		System.out.println(dp[N - 1] == 1001 ? -1 : dp[N - 1]);
	}
}