import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N + 1];
		boolean[][] friend = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a][b] = friend[b][a] = true;
			cnt[a]++;
			cnt[b]++;
		}

		int res = Integer.MAX_VALUE;
		for (int a = 1; a < N - 1; a++) {
			for (int b = a + 1; b < N; b++) {
				if (!friend[a][b])
					continue;

				for (int c = b + 1; c <= N; c++) {
					if (friend[a][c] && friend[b][c])
						res = Math.min(res, cnt[a] + cnt[b] + cnt[c] - 6);
				}
			}
		}

		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
}