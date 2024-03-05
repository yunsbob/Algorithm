import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;
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
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		int res = 1;
		for (int i = 1; i < max; i++) {
			visited = new boolean[N][N];
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[j][k] > i && !visited[j][k]) {
						bfs(j, k, i);
						cnt++;
					}
				}
			}

			res = Math.max(res, cnt);
		}

		System.out.println(res);
	}

	private static void bfs(int x, int y, int h) {
		Queue<XY> q = new ArrayDeque<>();
		q.offer(new XY(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			XY now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] <= h) continue;

				visited[nx][ny] = true;
				q.offer(new XY(nx, ny));
			}
		}
	}
}