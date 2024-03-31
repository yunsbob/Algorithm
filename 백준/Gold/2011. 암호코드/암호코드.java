import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int size = str.length();
		int[] dp = new int[size + 1];
		dp[0] = 1;
		dp[1] = 1;

		if (str.charAt(0) == '0') {
			System.out.println(0);
			System.exit(0);
		}

		for (int i = 2; i <= size; i++) {
			int now = str.charAt(i - 1) - '0';
			int prev = str.charAt(i - 2) - '0';

			if (now == 0) {
				if (prev == 1 || prev == 2) {
					dp[i] = dp[i - 2] % 1_000_000;
				} else {
					System.out.println(0);
					System.exit(0);
				}
			} else {
				int num = prev * 10 + now;

				if (10 <= num && num <= 26) {
					dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000;
				} else {
					dp[i] = dp[i - 1] % 1_000_000;
				}
			}
		}

		System.out.println(dp[size]);
	}
}