import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int w, h;
	private static char[][] map;
	private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static Queue<XY> fireQ, skQ;

	private static class XY {
		int x, y;

		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			fireQ = new ArrayDeque<>();
			skQ = new ArrayDeque<>();
			for (int j = 0; j < h; j++) {
				String input = br.readLine();

				for (int k = 0; k < w; k++) {
					char c = input.charAt(k);

					if (c == '*') {
						fireQ.offer(new XY(j, k));
					} else if (c == '@') {
						skQ.offer(new XY(j, k));
					}

					map[j][k] = c;
				}
			}

			int res = bfs();
			sb.append(res == -1 ? "IMPOSSIBLE" : res).append('\n');
		}

		System.out.println(sb);
	}

	private static int bfs() {
		int time = 1;
		while (true) {
			int size = skQ.size();

			while (size-- > 0) {
				XY now = skQ.poll();

				if (map[now.x][now.y] == '*')
					continue;

				for (int i = 0; i < 4; i++) {
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];

					if (nx < 0 || ny < 0 || nx >= h || ny >= w)
						return time;

					if (map[nx][ny] == '.') {
						map[nx][ny] = '@';
						skQ.offer(new XY(nx, ny));
					}
				}
			}

			if (skQ.isEmpty())
				break;

			size = fireQ.size();

			while (size-- > 0) {
				XY now = fireQ.poll();

				for (int i = 0; i < 4; i++) {
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];

					if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '#' || map[nx][ny] == '*')
						continue;

					map[nx][ny] = '*';
					fireQ.offer(new XY(nx, ny));
				}
			}

			time++;
		}

		return -1;
	}
}