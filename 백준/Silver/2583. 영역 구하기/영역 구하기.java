import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static boolean[][] arr;
	private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	private static class XY {
		int x, y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					arr[x][y] = true;
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (!arr[x][y]) {
					list.add(bfs(x, y));
				}
			}
		}

		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for (int size : list) {
			sb.append(size).append(' ');
		}

		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		Queue<XY> q = new ArrayDeque<>();
		int cnt = 1;
		arr[x][y] = true;
		q.add(new XY(x, y));

		while (!q.isEmpty()) {
			XY now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[nx][ny])
					continue;

				cnt++;
				arr[nx][ny] = true;
				q.offer(new XY(nx, ny));
			}
		}

		return cnt;
	}
}