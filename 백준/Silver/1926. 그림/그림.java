import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, area;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					visited[i][j] = true;
					cnt++;
					bfs(i, j);
				}
			}
		}

		System.out.println(cnt);
		System.out.println(area);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x, y});

		int cnt = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dir[i][0];
				int ny = now[1] + dir[i][1];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '0' || visited[nx][ny]) continue;

				visited[nx][ny] = true;
				cnt++;
				q.offer(new int[]{nx, ny});
			}
		}

		area = Math.max(area, cnt);
	}
}