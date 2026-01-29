import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	static class XY {
		int x, y;

		XY (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

	private static String bfs() {
		Queue<XY> q = new LinkedList<>();
		q.offer(new XY(0, 0));

		while (!q.isEmpty()) {
			XY now = q.poll();
			visited[now.x][now.y] = true;
			int next = map[now.x][now.y];

			for (int i = 0; i < 4; i++) {
				int nx = now.x + next * dxy[i][0];
				int ny = now.y + next * dxy[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

				if (map[nx][ny] == -1) return "HaruHaru";

				visited[nx][ny] = true;
				q.offer(new XY(nx, ny));
			}
		}

		return "Hing";
	}
}