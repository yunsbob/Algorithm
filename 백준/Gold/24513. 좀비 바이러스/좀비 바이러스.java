import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, res1 = 0, res2 = 0, res3 = 0;
	private static int[][] map, cnt;
	private static Queue<XY> q1 = new ArrayDeque<>();
	private static Queue<XY> q2 = new ArrayDeque<>();

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
		cnt = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;

				if (num == 1) {
					cnt[i][j] = 1;
					res1++;
					q1.offer(new XY(i, j));
				} else if (num == 2) {
					cnt[i][j] = 1;
					res2++;
					q2.offer(new XY(i, j));
				}
			}
		}

		bfs();
		System.out.println(res1 + " " + res2 + " " + res3);
	}

	private static void bfs() {
		int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

		int time = 2;
		while (!q1.isEmpty() || !q2.isEmpty()) {
			int size = q1.size();

			while (size-- > 0) {
				XY now = q1.poll();

				if (map[now.x][now.y] == 3) continue;

				for (int i = 0; i < 4; i++) {
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) continue;

					cnt[nx][ny] = time;
					map[nx][ny] = 1;
					res1++;
					q1.offer(new XY(nx, ny));
				}
			}

			size = q2.size();

			while (size-- > 0) {
				XY now = q2.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1 || map[nx][ny] == 2 || map[nx][ny] == 3) continue;

					if (map[nx][ny] == 1) {
						if (cnt[nx][ny] == time) {
							res1--;
							res3++;
							map[nx][ny] = 3;
						}
						continue;
					}

					cnt[nx][ny] = time;
					map[nx][ny] = 2;
					res2++;
					q2.offer(new XY(nx, ny));
				}
			}

			time++;
		}
	}
}