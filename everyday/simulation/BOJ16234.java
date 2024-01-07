package everyday.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
	private static int N, L, R;
	private static int[][] kingdoms;
	private static boolean[][] visited;
	private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static Queue<XY> moveQ = new ArrayDeque<>();

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
		kingdoms = new int[N][N];
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				kingdoms[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(check());
	}

	private static int check() {
		int cnt = -1;
		boolean flag = true;

		while (flag) {
			visited = new boolean[N][N];
			flag = false;
			cnt++;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						int sum = bfs(i, j);
						if (moveQ.size() == 1) moveQ.clear();
						else {
							flag = true;
							move(sum);
						}
					}
				}
			}
		}

		return cnt;
	}

	private static int bfs(int sx, int sy) {
		int sum = 0;
		Queue<XY> q = new ArrayDeque<>();
		q.offer(new XY(sx, sy));
		while (!q.isEmpty()) {
			XY now = q.poll();
			sum += kingdoms[now.x][now.y];
			moveQ.offer(new XY(now.x, now.y));

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
				int p = Math.abs(kingdoms[nx][ny] - kingdoms[now.x][now.y]);
				if (p < L || p > R) continue;
				visited[nx][ny] = true;
				q.offer(new XY(nx, ny));
			}
		}

		return sum;
	}

	private static void move(int sum) {
		int people = sum / moveQ.size();
		while (!moveQ.isEmpty()) {
			XY now = moveQ.poll();
			kingdoms[now.x][now.y] = people;
		}
	}
}
