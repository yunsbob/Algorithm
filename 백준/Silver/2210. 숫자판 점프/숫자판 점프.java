import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	private static String[][] arr;
	private static HashSet<String> visited;
	private static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new String[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 5; j++) {
				arr[i][j] = st.nextToken();
			}
		}

		visited = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, arr[i][j]);
			}
		}

		System.out.println(visited.size());
	}

	private static void dfs(int x, int y, String now) {
		if (now.length() == 6) {
			visited.add(now);
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dxy[i][0];
				int ny = y + dxy[i][1];

				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
					continue;

				dfs(nx, ny, now + arr[nx][ny]);
			}
		}
	}
}