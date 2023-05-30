package everyday.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ11051 {
	static int[][] memo;
    
    static int comb(int n, int r) {
		if(memo[n][r] > 0) {
			return memo[n][r]; 
		}
		else if(n == r || r == 0) {
			return memo[n][r] = 1;
		}
		return memo[n][r] = (comb(n - 1, r - 1) + comb(n - 1, r)) % 10007;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
        memo = new int[N + 1][N + 1];
			
		sb.append(comb(N, K));
        System.out.println(sb);
	}
}