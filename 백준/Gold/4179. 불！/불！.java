import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] map;
	private static int[][] dr = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static Queue<XY> jh = new ArrayDeque<>();
	private static Queue<XY> fire = new ArrayDeque<>();

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

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		int sx = 0, sy = 0;
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = in.charAt(j);
				if (map[i][j] == 'J') {
					sx = i;
					sy = j;
					map[i][j] = '.';
					jh.offer(new XY(sx, sy));
				} else if (map[i][j] == 'F') {
					fire.offer(new XY(i, j));
				}
			}
		}

		int res = bfs(sx, sy);
		System.out.println(res == -1 ? "IMPOSSIBLE" : res);
	}

	private static int bfs(int sx, int sy) {
		boolean[][] visited = new boolean[R][C];
		visited[sx][sy] = true;

		int cnt = 1;
		while (!jh.isEmpty()) {
			int size = jh.size();
			while (size-- > 0) {
				XY now = jh.poll();
				if (map[now.x][now.y] == 'F') continue;
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dr[i][0];
					int ny = now.y + dr[i][1];
					if (nx < 0 || ny < 0 || nx >= R || ny >= C) return cnt;
					if (map[nx][ny] == '.' && !visited[nx][ny]) {
						map[nx][ny] = 'J';
						visited[nx][ny] = true;
						jh.offer(new XY(nx, ny));
					}
				}
			}

			size =  fire.size();
			while (size-- > 0) {
				XY now = fire.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dr[i][0];
					int ny = now.y + dr[i][1];
					if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'F' || map[nx][ny] == '#') continue;
					map[nx][ny] = 'F';
					fire.offer(new XY(nx, ny));
				}
			}

			cnt++;
		}

		return -1;
	}
}