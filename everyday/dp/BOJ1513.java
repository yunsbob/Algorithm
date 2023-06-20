package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][][][] dp = new int[N+1][M+1][C+1][C+1];
        int[][] gameRoom = new int[N+1][M+1];
        dp[1][1][0][0] = 1;
        for (int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gameRoom[x][y] = i;
            if(x == 1 && y == 1) {
                dp[1][1][0][0] = 0;
                dp[1][1][1][i] = 1;
            }
        }

        for (int i = 1; i <= N; i++) { // x좌표
            for (int j = 1; j <= M; j++) { // y좌표
                for (int k = 0; k <= C; k++) { // 방문 수
                    for (int l = 0; l <= C; l++) { // 마지막 오락실
                        if (dp[i][j-1][k][l] != 0) {
                            if (gameRoom[i][j] == 0) {
                                dp[i][j][k][l] += dp[i][j-1][k][l];
                                dp[i][j][k][l] %= 1000007;
                            }
                            else if (gameRoom[i][j] > l) {
                                dp[i][j][k+1][gameRoom[i][j]] += dp[i][j-1][k][l];
                                dp[i][j][k+1][gameRoom[i][j]] %= 1000007;
                            }
                        }
                        if (dp[i-1][j][k][l] != 0) {
                            if (gameRoom[i][j] == 0) {
                                dp[i][j][k][l] += dp[i-1][j][k][l];
                                dp[i][j][k][l] %= 1000007;
                            }
                            else if (gameRoom[i][j] > l) {
                                dp[i][j][k+1][gameRoom[i][j]] += dp[i-1][j][k][l];
                                dp[i][j][k+1][gameRoom[i][j]] %= 1000007;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i <= C; i++) {
            int res = 0;
            for (int j = i; j <= C; j++) {
                res += dp[N][M][i][j];
                res %= 1000007;
            }
            sb.append(res).append(' ');
        }
        System.out.println(sb);
    }
}
