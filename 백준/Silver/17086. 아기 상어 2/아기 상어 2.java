import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static int[][] dxy = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	private static Queue<XY> q = new ArrayDeque<>();

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
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new XY(i, j));
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		int res = 1;

		while (!q.isEmpty()) {
			XY now = q.poll();

			for (int i = 0; i < 8; i++) {
				int nx = now.x + dxy[i][0];
				int ny = now.y + dxy[i][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0)
					continue;

				map[nx][ny] = map[now.x][now.y] + 1;
				q.offer(new XY(nx, ny));
				res = Math.max(res, map[nx][ny]);
			}
		}

		return res - 1;
	}
}