import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, resW = 0, resB = 0;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	private static class XY {
		int x, y;

		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j]);
				}
			}
		}

		System.out.println(resW + " " + resB);
	}

	private static void bfs(int sx, int sy, char c) {
		Queue<XY> q = new ArrayDeque<>();
		q.offer(new XY(sx, sy));
		visited[sx][sy] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			XY now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dxy[i][0];
				int ny = now.y + dxy[i][1];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] || map[nx][ny] != c)
					continue;

				cnt++;
				visited[nx][ny] = true;
				q.offer(new XY(nx, ny));
			}
		}

		if (c == 'B') {
			resB += cnt * cnt;
		} else {
			resW += cnt * cnt;
		}
	}
}