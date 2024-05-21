import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] dpR = new int[n];

		st = new StringTokenizer(br.readLine());
		dp[0] = arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
		}

		dpR[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			 dpR[i] = Math.max(dpR[i + 1] + arr[i], arr[i]);
		}

		int res = dp[0];
		for (int i = 1; i < n - 1; i++) {
			res = Math.max(res, Math.max(dp[i], dp[i - 1] + dpR[i + 1]));
		}

		System.out.println(Math.max(res, dp[n - 1]));
	}
}