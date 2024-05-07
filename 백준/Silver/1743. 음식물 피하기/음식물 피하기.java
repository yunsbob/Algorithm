import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, now;
	private static boolean[][] map;
	private static int[][] drc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j]) {
					now = 0;
					dfs(i, j);
					res = Math.max(res, now);
				}
			}
		}

		System.out.println(res);
	}

	private static void dfs(int r, int c) {
		map[r][c] = false;
		now++;

		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			if (nr >= 1 && nc >= 1 && nr <= N && nc <= M && map[nr][nc])
				dfs(nr, nc);
		}
	}
}