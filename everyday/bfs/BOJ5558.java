package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5558 {
	private static int H, W;
	private static char end;
	private static char[][] map;
	private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	private static class XY {
		int x, y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		int N = Integer.parseInt(st.nextToken());
		end = (char)('0' + N);

		int startX = 0, startY = 0;
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}

		int res = bfs(startX, startY);
		System.out.println(res);
	}

	private static int bfs(int startX, int startY) {
		Queue<XY> q = new ArrayDeque<>();
		q.offer(new XY(startX, startY));
		int[][] visited = new int[H][W];
		visited[startX][startY] = 1;
		char nowNum = '0';

		while (!q.isEmpty()) {
			XY now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny] != 0 || map[nx][ny] == 'X') continue;

				if (map[nx][ny] == end && nowNum == end - 1) return visited[now.x][now.y];
				else if (map[nx][ny] == nowNum + 1) {
					q.clear();
					int cnt = visited[now.x][now.y];
					visited = new int[H][W];
					visited[nx][ny] = cnt + 1;
					map[nx][ny] = '.';
					nowNum++;
					q.offer(new XY(nx, ny));
					break;
				} else {
					visited[nx][ny] = visited[now.x][now.y] + 1;
					q.offer(new XY(nx, ny));
				}
			}
		}

		return 0;
	}
}
