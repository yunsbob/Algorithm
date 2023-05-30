package everyday.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ1010 {
	static int[][] memo;

    static int comb(int n, int r) {
		if(memo[n][r] > 0) {
			return memo[n][r]; 
		}
		else if(n == r || r == 0) {
			return memo[n][r] = 1;
		}

		return memo[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        memo = new int[30][30];
        
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(comb(M, N) + "\n");
		}
		System.out.println(sb);
	}
}