import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, K;
	private static int[][] map;
	private static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static List<Queue<XY>> q = new ArrayList<>();

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

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= K; i++) {
			q.add(new ArrayDeque());
		}

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				q.get(map[i][j]).offer(new XY(i, j));
			}
		}

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		if (map[X][Y] == 0)
			bfs(S, X, Y);

		System.out.println(map[X][Y]);
	}

	private static void bfs(int s, int px, int py) {
		int cnt = 0;

		while (cnt++ < s) {
			for (int i = 1; i <= K; i++) {
				int size = q.get(i).size();

				while (size-- > 0) {
					XY now = q.get(i).poll();

					for (int j = 0; j < 4; j++) {
						int nx = now.x + dxy[j][0];
						int ny = now.y + dxy[j][1];

						if (nx <= 0 || ny <= 0 || nx > N || ny > N || map[nx][ny] != 0)
							continue;

						map[nx][ny] = map[now.x][now.y];

						if (nx == px && ny == py)
							return;

						q.get(i).offer(new XY(nx, ny));
					}
				}
			}
		}
	}
}