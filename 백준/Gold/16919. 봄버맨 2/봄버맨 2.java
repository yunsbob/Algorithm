import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append('O');
				}
				sb.append('\n');
			}
		} else if (N == 1) {
			for (int i = 0; i < R; i++) {
				sb.append(br.readLine()).append('\n');
			}
		} else if (N % 4 == 3) {
			char[][] map = new char[R][C];
			char[][] anotherMap = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
				Arrays.fill(anotherMap[i], 'O');
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'O') {
						anotherMap[i][j] = '.';
						if (i + 1 < R)
							anotherMap[i + 1][j] = '.';
						if (j + 1 < C)
							anotherMap[i][j + 1] = '.';
						if (i - 1 >= 0)
							anotherMap[i - 1][j] = '.';
						if (j - 1 >= 0)
							anotherMap[i][j - 1] = '.';
					}
				}
			}
			for (int i = 0; i < R; i++) {
				sb.append(anotherMap[i]).append('\n');
			}
		} else if (N % 4 == 1) {
			char[][] map = new char[R][C];
			char[][] anotherMap = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
				Arrays.fill(anotherMap[i], 'O');
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'O') {
						anotherMap[i][j] = '.';
						if (i + 1 < R)
							anotherMap[i + 1][j] = '.';
						if (j + 1 < C)
							anotherMap[i][j + 1] = '.';
						if (i - 1 >= 0)
							anotherMap[i - 1][j] = '.';
						if (j - 1 >= 0)
							anotherMap[i][j - 1] = '.';
					}
				}
			}
			for (int i = 0; i < R; i++) {
				map[i] = anotherMap[i].clone();
				Arrays.fill(anotherMap[i], 'O');
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'O') {
						anotherMap[i][j] = '.';
						if (i + 1 < R)
							anotherMap[i + 1][j] = '.';
						if (j + 1 < C)
							anotherMap[i][j + 1] = '.';
						if (i - 1 >= 0)
							anotherMap[i - 1][j] = '.';
						if (j - 1 >= 0)
							anotherMap[i][j - 1] = '.';
					}
				}
			}
			for (int i = 0; i < R; i++) {
				sb.append(anotherMap[i]).append('\n');
			}
		}
        
		System.out.println(sb);
	}
}