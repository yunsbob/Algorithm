package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
	static int N, result = 0;
	static boolean[][] map;
	
	public static void move(int x, int y, int status) {
		if(x == N && y == N) {
			result++;
			return;
		}
		if(status == 0 || status == 2) { // 가로 또는 대각선 일때
			if(x + 1 <= N && !map[y][x+1]) { // 가로로 이동
				move(x + 1, y, 0);
			}
		}
		if(status == 1 || status == 2) { // 세로 또는 대각선 일때
			if(y + 1 <= N && !map[y+1][x]) { // 세로로 이동
				move(x, y + 1, 1);
			}
		}
		if(x + 1 <= N && y + 1 <= N && !map[y+1][x+1] && !map[y+1][x] && !map[y][x+1]) { // 대각선 이동
				move(x + 1, y + 1, 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				if(st.nextToken().equals("1")) { // 못가는 위치 저장
					map[i][j] = true;
					if(i == N && j == N) {
						System.out.println(0);
						System.exit(0);
					}
				}
			}
		}
		move(2, 1, 0);
		System.out.println(result);
	}
}