import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, res = Integer.MAX_VALUE;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(res);
 	}

	 private static void dfs(int now, int flag) {
		if (now == N) {
			int start = 0, link = 0;

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (((flag >> i) & 1) != ((flag >> j) & 1))
						continue;

					if (((flag >> i) & 1) == 1) {
						start += arr[i][j] + arr[j][i];
					} else {
						link += arr[i][j] + arr[j][i];
					}
				}
			}

			res = Math.min(res, Math.abs(start - link));
		} else {
			dfs(now + 1,flag | (1 << now));
			dfs(now + 1, flag);
		}
	 }
}