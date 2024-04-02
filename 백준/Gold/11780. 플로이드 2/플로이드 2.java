import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] map;
	private static List<Integer>[][] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		list = new ArrayList[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 100_001;
				list[i][j] = new ArrayList<>();
			}

			map[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], c);
		}

		floyd();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 100_001) {
					sb.append("0 ");
				} else {
					sb.append(map[i][j]).append(' ');
				}
			}
			sb.append('\n');
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || map[i][j] == 100_001) {
					sb.append("0\n");
				} else {
					sb.append(list[i][j].size() + 2).append(' ').append(i).append(' ');
					for (int next : list[i][j]) {
						sb.append(next).append(' ');
					}
					sb.append(j).append('\n');
				}
			}
		}

		System.out.println(sb);
	}

	private static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						tracking(i, j, k);
					}
				}
			}
		}
	}

	private static void tracking(int i, int j, int k) {
		list[i][j].clear();

		for (int next : list[i][k]) {
			list[i][j].add(next);
		}
		list[i][j].add(k);
		for (int next : list[k][j]) {
			list[i][j].add(next);
		}
	}
}