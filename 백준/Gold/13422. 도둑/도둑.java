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
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N == M ? N + 1 : N + M];

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[j] = arr[j - 1] + Integer.parseInt(st.nextToken());
			}

			if (N != M) {
				for (int j = N + 1; j < N + M; j++) {
					arr[j] = arr[j - 1] + arr[j - N] - arr[j - N - 1];
				}
			}

			int res = 0;
			for (int j = M; j < (N == M ? N + 1 : N + M); j++) {
				int sum = arr[j] - arr[j - M];

				if (sum < K)
					res++;
			}

			sb.append(res).append('\n');
		}

		System.out.println(sb);
	}
}