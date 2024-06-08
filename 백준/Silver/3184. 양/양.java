import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, o = 0, v = 0;
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

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(o + " " + v);
	}

	private static void bfs(int x, int y) {
		int s = 0, w = 0;
		Queue<XY> q = new ArrayDeque<>();
		q.offer(new XY(x, y));
		visited[x][y] = true;

		if (map[x][y] == 'o') {
			s++;
		} else if (map[x][y] == 'v') {
			w++;
		}

		while (!q.isEmpty()) {
			XY now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dxy[i][0];
				int ny = now.y + dxy[i][1];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#' || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				if (map[nx][ny] == 'o') {
					s++;
				} else if (map[nx][ny] == 'v') {
					w++;
				}

				q.offer(new XY(nx, ny));
			}
		}

		if (s > w) {
			o += s;
		} else {
			v += w;
		}
	}
}