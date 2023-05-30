package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
	static int M, N; // M : 세로, N : 가로
	static int[][] arr;
	static Integer[][] dp;
	static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	private static int DFS(int y, int x) {
		int nx, ny;
		if(y == M - 1 && x == N - 1) {
			return 1;
		}
		if(dp[y][x] != null) {
			return dp[y][x];
		}
		dp[y][x] = 0;
		for(int i = 0; i < 4; i++) {
			nx = x + dxy[i][0];
			ny = y + dxy[i][1];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(arr[ny][nx] < arr[y][x]) dp[y][x] += DFS(ny, nx);
		}
		return dp[y][x];
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        dp = new Integer[M][N];
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        System.out.println(DFS(0, 0));
	}
}