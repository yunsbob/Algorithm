import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, res = -1_000_000_000;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs( 0, 0);

		System.out.println(res);
	}

	static void dfs(int cnt, int sum) {
		if (cnt == K) {
			res = Math.max(res, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			A: for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;

				for (int k = 0; k < 4; k++) {
					int nx = i + dxy[k][0];
					int ny = j + dxy[k][1];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (visited[nx][ny])
							continue A;
					}
				}

				visited[i][j] = true;
				dfs(cnt + 1, sum + map[i][j]);
				visited[i][j] = false;
			}
		}
	}
}