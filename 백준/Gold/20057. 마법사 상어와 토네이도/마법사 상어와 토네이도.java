import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, cnt = 0, res = 0;
	private static int[][] map;
	private static int[][] dxy = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	private static int[][][] spread = {{{-1, 1}, {1, 1}, {-2, 0}, {-1, 0}, {1, 0}, {2, 0}, {-1, -1}, {1, -1}, {0, -2}},
		{{-1, -1}, {-1, 1}, {0, -2}, {0, -1}, {0, 1}, {0, 2}, {1, -1}, {1, 1}, {2, 0}},
		{{-1, -1}, {1, -1}, {-2, 0}, {-1, 0}, {1, 0}, {2, 0}, {-1, 1}, {1, 1}, {0, 2}},
		{{1, -1}, {1, 1}, {0, -2}, {0, -1}, {0, 1}, {0, 2}, {-1, -1}, {-1, 1}, {-2, 0}}};
	private static int[] rate = {1, 1, 2, 7, 7, 2, 10, 10, 5};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tornado();
		System.out.println(res);
	}

	private static void tornado() {
		int x = N / 2, y = N / 2;

		while (true) {
			for (int i = 0; i < 4; i++) {
				if (i % 2 == 0)
					cnt++;

				for (int j = 0; j < cnt; j++) {
					int nx = x + dxy[i][0];
					int ny = y + dxy[i][1];

					if (check(nx, ny))
						return;

					spread(nx, ny, i, map[nx][ny]);

					x = nx;
					y = ny;
				}
			}
		}
	}

	private static void spread(int x, int y, int d, int sand) {
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			int nx = x + spread[d][i][0];
			int ny = y + spread[d][i][1];
			int amount = (sand * rate[i]) / 100;

			if (check(nx, ny))
				res += amount;
			else
				map[nx][ny] += amount;

			sum += amount;
		}

		int nx = x + dxy[d][0];
		int ny = y + dxy[d][1];
		int amount = sand - sum;

		if (check(nx, ny))
			res += amount;
		else
			map[nx][ny] += amount;

		map[x][y] = 0;
	}

	private static boolean check(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return true;
		else
			return false;
	}
}