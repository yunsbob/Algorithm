package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {
	private static int L, R, C, SL, SR, SC;
	private static char[][][] map;
	private static int[][][] visited;
	private static int[][] dr = {{0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

	private static class LRC {
		int L, R, C;

		public LRC(int l, int r, int c) {
			L = l;
			R = r;
			C = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			if (L == 0) break;
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[L][R][C];

			for (int l = 0; l < L; l++) {
				for (int r = 0; r <= R; r++) {
					String str = br.readLine();
					if (r == R) continue;
					for (int c = 0; c < C; c++) {
						map[l][r][c] = str.charAt(c);
						if (map[l][r][c] == 'S') {
							SL = l;
							SR = r;
							SC = c;
						}
					}
				}
			}

			int res = bfs();
			if (res != 0) sb.append("Escaped in ").append(res).append(" minute(s).\n");
			else sb.append("Trapped!\n");
		}

		System.out.println(sb);
	}

	private static int bfs() {
		visited = new int[L][R][C];
		Queue<LRC> q = new ArrayDeque<>();
		q.offer(new LRC(SL, SR, SC));

		while (!q.isEmpty()) {
			LRC now = q.poll();
			for (int i = 0; i < 6; i++) {
				int nl = now.L + dr[i][0];
				int nx = now.R + dr[i][1];
				int ny = now.C + dr[i][2];

				if (nl < 0 || nx < 0 || ny < 0 || nl >= L || nx >= R || ny >= C || visited[nl][nx][ny] != 0) continue;
				if (map[nl][nx][ny] == '.') {
					visited[nl][nx][ny] = visited[now.L][now.R][now.C] + 1;
					q.offer(new LRC(nl, nx, ny));
				} else if (map[nl][nx][ny] == 'E') {
					return visited[now.L][now.R][now.C] + 1;
				}
			}
		}

		return 0;
	}
}
