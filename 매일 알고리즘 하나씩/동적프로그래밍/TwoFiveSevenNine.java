import java.io.*;

public class TwoFiveSevenNine {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N];
		int[] score = new int[N];
        
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = score[0];
		if (N >= 2) {
			dp[1] = score[0] + score[1];
		}
        if (N >= 3) {
            dp[2] = Math.max(score[0], score[1]) + score[2];
            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i-2] , dp[i-3] + score[i-1]) + score[i];
            }
		}

        sb.append(dp[N-1]);
        System.out.println(sb);
    }
}
