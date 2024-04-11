import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static boolean[][] map;
	private static int[][] dxy = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

	private static class XY {
		int x, y, cnt;

		public XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1"))
					map[i][j] = true;
			}
		}

		int res = 0;
		int[][] v = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j]) {
					res = Math.max(res, bfs(i, j));
					v[i][j] = bfs(i, j);
				}
			}
		}

		System.out.println(res);
	}

	private static int bfs(int sx, int sy) {
		Queue<XY> q = new ArrayDeque<>();
		boolean[][] check = new boolean[N][M];
		q.offer(new XY(sx, sy, 0));
		check[sx][sy] = true;

		while (!q.isEmpty()) {
			XY now = q.poll();
			int cnt = now.cnt + 1;

			for (int i = 0; i < 8; i++) {
				int nx = now.x + dxy[i][0];
				int ny = now.y + dxy[i][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || check[nx][ny])
					continue;

				if (map[nx][ny])
					return cnt;

				check[nx][ny] = true;
				q.offer(new XY(nx, ny, cnt));
			}
		}

		return -1;
	}
}