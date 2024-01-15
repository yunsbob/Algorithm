import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	private static class XY {
		int x, y;
		XY(int x, int y) {
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
			}
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					res++;
					bfs(i, j);
				}
			}
		}

		System.out.println(res);
	}

	private static void bfs(int x, int y) {
		Queue<XY> q = new ArrayDeque<>();
		map[x][y] = 1;

		q.offer(new XY(x, y));
		while (!q.isEmpty()) {
			XY now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = (now.x + dir[i][0] + N) % N;
				int ny = (now.y + dir[i][1] + M) % M;

				if (map[nx][ny] == 1) continue;
				map[nx][ny] = 1;
				q.offer(new XY(nx, ny));
			}
		}
	}
}