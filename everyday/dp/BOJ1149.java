package everyday.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ1149 {
	static int dp[][];
	static int N;
	static int[][] arr;
	
	public static int sum(int depth, int x) {
		if(depth == -1) {
			return 0;
		}
		if(dp[depth][x] != 0) {
			return dp[depth][x];
		}
		else {
			if(x == 0) {
				return dp[depth][0] = Math.min(sum(depth - 1, 1), sum(depth - 1, 2)) + arr[depth][0];
			}
			else if(x == 1) {
				return dp[depth][1] = Math.min(sum(depth - 1, 0), sum(depth - 1, 2)) + arr[depth][1];
			}
			else {
				return dp[depth][2] = Math.min(sum(depth - 1, 0), sum(depth - 1, 1)) + arr[depth][2];
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(Math.min(sum(N-1, 0), Math.min(sum(N-1, 1), sum(N-1, 2))));
	}
}