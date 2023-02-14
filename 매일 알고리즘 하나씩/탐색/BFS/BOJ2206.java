import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ2206 {
	static int N, M;
	static Queue<XY> move = new LinkedList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][][] visited;
	static boolean[][] map;
	static XY now;
	
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
		int nX, nY;
		boolean check;
		while(!move.isEmpty()) {
			now = move.poll();
			if(now.x == M && now.y == N) {
				return;
			}
			for(int i = 0; i < 4; i++) {
				nX = now.x + dx[i];
				nY = now.y + dy[i];
				check = now.check;
				if(nX < 1 || nY < 1 || nX > M || nY > N){
					continue;
				}
				if(map[nY][nX]) {
					if(!check) {
						move.offer(new XY(nX, nY, true));
						visited[nY][nX][1] = visited[now.y][now.x][0] + 1;
					}
					continue;
				}
				if(!check && visited[nY][nX][0] == 0) {
					visited[nY][nX][0] = visited[now.y][now.x][0] + 1;
					visited[nY][nX][1] = visited[now.y][now.x][1] + 1;
					move.offer(new XY(nX, nY, check));
				}
				else if(check && visited[nY][nX][1] == 0){
					visited[nY][nX][1] = visited[now.y][now.x][1] + 1;
					move.offer(new XY(nX, nY, check));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[N+1][M+1][2];
		map = new boolean[N+1][M+1];
		visited[1][1][0] = 1;
		
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= M; j++) {
				if(str.charAt(j-1) == '1') {
					map[i][j] = true;
				}
			}
		}
		
		move.offer(new XY(1, 1, false));
		bfs();

		if(now.x == M && now.y == N) {
			if(visited[N][M][0] == 0) {
				System.out.println(visited[N][M][1]);				
			}
			else {
				System.out.println(visited[N][M][0]);
			}
		}
		else {
			System.out.println("-1");
		}
	}
}