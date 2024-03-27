import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		game(0, map);

		System.out.println(res);
	}

	private static void game(int cnt, int[][] map) {
		if (cnt == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (res < map[i][j])
						res = map[i][j];
				}
			}

			return;
		}

		int[][] now = new int[N][N];
		for (int i = 0; i < N; i++) {
			now[i] = map[i].clone();
		}

		for (int i = 0; i < 4; i++) {
			move(i, map);
			game(cnt + 1, map);

			for (int j = 0; j < N; j++) {
				map[j] = now[j].clone();
			}
		}
	}

	private static void move(int dir, int[][] map) {
		if (dir == 0) {
			for (int i = 0; i < N; i++) {
				int idx = 0;
				int num = 0;

				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						if (num == map[i][j]) {
							map[i][idx - 1] = num * 2;
							num = 0;
							map[i][j] = 0;
						} else {
							num = map[i][j];
							map[i][j] = 0;
							map[i][idx] = num;
							idx++;
						}
					}
				}
			}
		} else if (dir == 1) {
			for (int i = 0; i < N; i++) {
				int idx = 0;
				int num = 0;

				for (int j = 0; j < N; j++) {
					if (map[j][i] != 0) {
						if (num == map[j][i]) {
							map[idx - 1][i] = num * 2;
							num = 0;
							map[j][i] = 0;
						} else {
							num = map[j][i];
							map[j][i] = 0;
							map[idx][i] = num;
							idx++;
						}
					}
				}
			}
		} else if (dir == 2) {
			for (int i = 0; i < N; i++) {
				int idx = N - 1;
				int num = 0;

				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						if (num == map[i][j]) {
							map[i][idx + 1] = num * 2;
							num = 0;
							map[i][j] = 0;
						} else {
							num = map[i][j];
							map[i][j] = 0;
							map[i][idx] = num;
							idx--;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				int idx = N - 1;
				int num = 0;

				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] != 0) {
						if (num == map[j][i]) {
							map[idx + 1][i] = num * 2;
							num = 0;
							map[j][i] = 0;
						} else {
							num = map[j][i];
							map[j][i] = 0;
							map[idx][i] = num;
							idx--;
						}
					}
				}
			}
		}
	}
}