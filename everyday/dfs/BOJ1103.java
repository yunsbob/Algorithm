package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1103 {
    private static int N, M, res = 1;
    private static boolean[][] visited;
    private static char[][] map;
    private static int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dp[0][0] = 1;
        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int x, int y){
        res = Math.max(res, dp[x][y]);

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i][0] * (map[x][y] - '0');
            int ny = y + dr[i][1] * (map[x][y] - '0');

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'H') continue;

            if(dp[x][y] + 1 <= dp[nx][ny]) continue;

            if (visited[nx][ny]){
                System.out.println(-1);
                System.exit(0);
            }

            dp[nx][ny] = dp[x][y] + 1;
            visited[nx][ny] = true;
            dfs(nx, ny);
            visited[nx][ny] = false;
        }
    }
}
