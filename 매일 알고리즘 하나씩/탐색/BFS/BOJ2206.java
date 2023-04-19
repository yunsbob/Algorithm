package everyday.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
	static int N, M;
	static int[][] dr = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int[][][] visited;
	static boolean[][] map;
	
	private static class XY {
		int x, y;
		boolean check;

		public XY(int x, int y, boolean check) {
			this.x = x;
			this.y = y;
			this.check = check;
		}
	}
	
	public static void bfs() {
		Queue<XY> move = new ArrayDeque<>();
		move.offer(new XY(0, 0, false));
		
		while(!move.isEmpty()) {
			XY now = move.poll();
			if(now.x == M - 1 && now.y == N - 1) {
				System.out.println(visited[N - 1][M - 1][0] == 0 ? visited[N - 1][M - 1][1] : visited[N - 1][M - 1][0]);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int nX = now.x + dr[i][0];
				int nY = now.y + dr[i][1];
				if(nX < 0 || nY < 0 || nX >= M || nY >= N) continue;
				if(map[nY][nX]) {
					if(!now.check) {
						move.offer(new XY(nX, nY, true));
						visited[nY][nX][1] = visited[now.y][now.x][0] + 1;
					}
					continue;
				}
				if(!now.check && visited[nY][nX][0] == 0) {
					visited[nY][nX][0] = visited[now.y][now.x][0] + 1;
					visited[nY][nX][1] = visited[now.y][now.x][1] + 1;
					move.offer(new XY(nX, nY, now.check));
				}
				else if(now.check && visited[nY][nX][1] == 0){
					visited[nY][nX][1] = visited[now.y][now.x][1] + 1;
					move.offer(new XY(nX, nY, now.check));
				}
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[N][M][2];
		map = new boolean[N][M];
		visited[0][0][0] = visited[0][0][1] = 1;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == '1') {
					map[i][j] = true;
				}
			}
		}
		
		bfs();
	}
}