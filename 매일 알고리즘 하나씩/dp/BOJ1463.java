package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    static int[] dp;
	public static int Search(int N) {
		if(dp[N] != 0 || N == 1) {
			return dp[N];
		}
		else if (N % 6 == 0) {
			return dp[N] = Math.min(Search(N - 1), Math.min(Search(N / 3), Search(N / 2))) + 1;
		}
		else if (N % 3 == 0) {
			return dp[N] = Math.min(Search(N / 3), Search(N - 1)) + 1;
		}
		else if (N % 2 == 0) {
			return dp[N] = Math.min(Search(N / 2), Search(N - 1)) + 1;
		}
		else {
			return dp[N] = Search(N - 1) + 1;
		}
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        dp = new int [N + 1];
        dp[1] = 0;
        sb.append(Search(N));
        System.out.println(sb);
    }
}
