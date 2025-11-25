import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dxy = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

	private static class XY {
		int x, y;
		XY (int x, int y) {
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
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					if (bfs(i, j)) res++;
				}
			}
		}

		System.out.println(res);
	}

	private static boolean bfs(int x, int y) {
		int top = map[x][y];
		Queue<XY> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new XY(x, y));

		boolean isTop = true;

		while (!q.isEmpty()) {
			XY now = q.poll();

			for (int i = 0; i < 8; i++) {
				int nX = now.x + dxy[i][0];
				int nY = now.y + dxy[i][1];

				if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;

				if (map[nX][nY] > top) isTop = false;

				if (!visited[nX][nY] && map[nX][nY] == top) {
					visited[nX][nY] = true;
					q.offer(new XY(nX, nY));
				}
			}
		}

		return isTop;
	}
}