import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, res;
	private static int[][] lab;
	private static boolean[][] visited;
	private static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static final int DOWN = 0, RIGHT = 1, UP = 2, LEFT = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		visited = new boolean[N][M];

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());

				if (lab[i][j] == 9) {
					list.add(new int[]{i, j});
				}
			}
		}

		res = 0;
		if (!list.isEmpty()) {
			for (int[] start: list) {
				findSeat(start[0], start[1]);
			}
		}

		System.out.println(res);
	}

	private static void findSeat(int x, int y) {
		if (!visited[x][y]) {
			visited[x][y] = true;
			res++;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dxy[i][0];
			int ny = y + dxy[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			blowing(nx, ny, i);
		}

	}

	private static void blowing(int x, int y, int dir) {
		if (!visited[x][y]) {
			res++;
			visited[x][y] = true;
		}

		if (dir == DOWN) {
			if ((lab[x][y] == 0 || lab[x][y] == 1) && x + 1 < N) {
				blowing(++x, y, DOWN);
			} else if (lab[x][y] == 3 && y - 1 >= 0) {
				blowing(x, --y, LEFT);
			} else if (lab[x][y] == 4 && y + 1 < M) {
				blowing(x, ++y, RIGHT);
			}
		} else if (dir == RIGHT) {
			if ((lab[x][y] == 0 || lab[x][y] == 2) && y + 1 < M) {
				blowing(x, ++y, RIGHT);
			} else if (lab[x][y] == 3 && x - 1 >= 0) {
				blowing(--x, y, UP);
			} else if (lab[x][y] == 4 && x + 1 < N) {
				blowing(++x, y, DOWN);
			}
		} else if (dir == UP) {
			if ((lab[x][y] == 0 || lab[x][y] == 1) && x - 1 >= 0) {
				blowing(--x, y, UP);
			} else if (lab[x][y] == 3 && y + 1 < M) {
				blowing(x, ++y, RIGHT);
			} else if (lab[x][y] == 4 && y - 1 >= 0) {
				blowing(x, --y, LEFT);
			}
		} else if (dir == LEFT) {
			if ((lab[x][y] == 0 || lab[x][y] == 2) && y - 1 >= 0) {
				blowing(x, --y, LEFT);
			} else if (lab[x][y] == 3 && x + 1 < N) {
				blowing(++x, y, DOWN);
			} else if (lab[x][y] == 4 && x - 1 >= 0) {
				blowing(--x, y, UP);
			}
		}
	}
}