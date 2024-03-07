import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int W, H;
	private static char[][] map;
	private static int[][][] dist;
	private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	private static class XY {
		int x, y, d, cost;

		XY(int x, int y, int d, int cost) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		dist = new int[H][W][4];
		int sx = 0, sy = 0;
		boolean flag = true;
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				Arrays.fill(dist[i][j], 10000);
				if (map[i][j] == 'C') {
					if (flag) {
						sx = i;
						sy = j;
						flag = false;
					}
				}
			}
		}

		System.out.println(dijkstra(sx, sy));
	}

	private static int dijkstra(int x, int y) {
		PriorityQueue<XY> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		for (int i = 0; i < 4; i++) {
			dist[x][y][i] = 0;
			pq.offer(new XY(x, y, i, 0));
		}

		while (!pq.isEmpty()) {
			XY now = pq.poll();

			if (dist[now.x][now.y][now.d] < now.cost)
				continue;

			if ((now.x != x || now.y != y) && map[now.x][now.y] == 'C')
				return now.cost;

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				int cost = now.cost;

				if (i != now.d)
					cost++;

				if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*' || cost >= dist[nx][ny][i])
					continue;

				dist[nx][ny][i] = cost;
				pq.offer(new XY(nx, ny, i, cost));
			}
		}

		return -1;
	}
}