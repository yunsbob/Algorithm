import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i- 1] + Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		long min = Long.MAX_VALUE;
		for (int k = 1; k <= n / 2; k++) {
			for (int i = k; i <= n; i++) {
				for (int j = i + k; j <= n; j++) {
					long num = Math.abs((arr[i] - arr[i - k]) - (arr[j] - arr[j - k]));

					if (num <= min) {
						min = num;
						cnt = k;
					}
				}
			}
		}

		sb.append(cnt).append('\n').append(min);
		System.out.println(sb);
	}
}