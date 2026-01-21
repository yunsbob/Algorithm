import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int N, M;
	private static boolean res = false;
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			char[] in = br.readLine().toCharArray();

			for (int j = 0; j < N; j++) {
				map[i][j] = in[j] - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			if (map[0][i] == 1) {
				continue;
			}

			bfs(0, i);

			if (res) {
				break;
			}
		}

		System.out.println(res ? "YES" : "NO");
	}

	public static void bfs(int x, int y) {
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(x, y));
		map[x][y] = 1;

		while (!q.isEmpty()) {
			XY now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dxy[i][0];
				int ny = now.y + dxy[i][1];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny] == 1) {
					continue;
				}

				if (nx == M - 1) {
					res = true;
					return;
				}

				map[nx][ny] = 1;
				q.add(new XY(nx, ny));
			}
		}
	}
}