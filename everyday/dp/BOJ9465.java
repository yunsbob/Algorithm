package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N];
            int[][] arr = new int[2][N];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            for (int j = 1; j < N; j++) {
                dp[0][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + arr[0][j]);
                dp[1][j] = Math.max(dp[1][j - 1], dp[0][j - 1] + arr[1][j]);
            }

            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append('\n');
        }

        System.out.println(sb);
    }
}
