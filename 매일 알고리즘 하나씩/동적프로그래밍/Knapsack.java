import java.io.*;
import java.util.*;

public class Knapsack {
    static int[][] dp, travel;
    public static int knapsack(int n, int k){
		if (n < 1)
			return 0;
        if(dp[n][k] != -1){
            return dp[n][k];
        }
		else {
			if(k - travel[n][0] >= 0) {
                return dp[n][k] = Math.max(knapsack(n - 1, k), knapsack(n - 1, k - travel[n][0]) + travel[n][1]);
			}
			else {
                return dp[n][k] = knapsack(n - 1, k);
			}
		}
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        travel = new int[N+1][2];
        dp = new int[N+1][K+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            travel[i][0] = Integer.parseInt(st.nextToken());
            travel[i][1] = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= K; j++){
                dp[i][j] = -1;
            }
        }
        
        sb.append(knapsack(N, K));
        System.out.println(sb);
    }
}