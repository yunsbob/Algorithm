import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		friends = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(friends[i], N + 1);
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1)
				break;

			friends[a][b] = friends[b][a] = 1;
		}

		floyd();

		int score = N + 1;
		int cnt = 0;
		int[] res = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;

				res[i] = Math.max(res[i], friends[i][j]);
			}

			if (score > res[i]) {
				score = res[i];
				cnt = 1;
			} else if (score == res[i]) {
				cnt++;
			}
		}

		sb.append(score).append(' ').append(cnt).append('\n');
		for (int i = 1; i <= N; i++) {
			if (res[i] == score)
				sb.append(i).append(' ');
		}

		System.out.println(sb);
	}

	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;

				for (int j = 1; j <= N; j++) {
					friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
				}
			}
		}
	}
}