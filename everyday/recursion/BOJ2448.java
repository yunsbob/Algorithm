package everyday.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2448 {
	private static int N;
	private static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N * 2 - 1];
		draw(0, N - 1, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				sb.append(map[i][j] ? '*' : ' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void draw(int x, int y, int N) {
		if (N == 3) {
			map[x][y] = map[x + 1][y - 1] = map[x + 1][y + 1] = true;
			for (int i = 0; i < 5; i++) {
				map[x + 2][y + i - 2] = true;
			}
		}
		else {
			draw(x, y, N / 2);
			draw(x + N / 2, y - N / 2, N / 2);
			draw(x + N / 2, y + N / 2, N / 2);
		}
	}
}
