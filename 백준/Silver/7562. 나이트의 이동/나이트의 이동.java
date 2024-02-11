import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] dir = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

	private static class XY {
		int x, y;
		XY (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			sb.append(bfs(N, sx, sy, ex, ey)).append('\n');
		}

		System.out.println(sb);
	}

	private static int bfs(int size, int sx, int sy, int ex, int ey) {
		if (sx == ex && sy == ey) return 0;

		Queue<XY> q = new ArrayDeque<>();
		int[][] map = new int[size][size];
		map[sx][sy] = 0;
		q.offer(new XY(sx, sy));

		while (!q.isEmpty()) {
			XY now = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if (nx < 0 || ny < 0 || nx >= size || ny >= size || map[nx][ny] != 0) continue;
				if (nx == ex && ny == ey) return map[now.x][now.y] + 1;
				map[nx][ny] = map[now.x][now.y] + 1;
				q.offer(new XY(nx, ny));
			}
		}

		return 0;
	}
}