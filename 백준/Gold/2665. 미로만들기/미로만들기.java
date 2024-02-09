import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	private static int n;
	private static boolean[][] map;
	private static int[][] cnt;
	private static int[][] dr = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	private static class XY {
		int x, y;
		XY (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		cnt = new int[n][n];
		for (int i = 0; i < n; i++) {
			String in = br.readLine();
			Arrays.fill(cnt[i], 2500);
			for (int j = 0; j < n; j++) {
				if (in.charAt(j) == '0') {
					map[i][j] = true;
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<XY> q = new ArrayDeque<>();
		q.offer(new XY(0, 0));
		cnt[0][0] = 0;

		while (!q.isEmpty()) {
			XY now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dr[i][0];
				int ny = now.y + dr[i][1];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || cnt[now.x][now.y] >= cnt[nx][ny]) continue;

				if (map[nx][ny]) cnt[nx][ny] = cnt[now.x][now.y] + 1;
				else cnt[nx][ny] = cnt[now.x][now.y];

				q.offer(new XY(nx, ny));
			}
		}

		return cnt[n - 1][n - 1];
	}
}