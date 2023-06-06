package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14712 {
    private static int N, M, res = 0;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];

        dfs(1, 1);

        System.out.println(res);
    }

    private static void dfs(int x, int y){
        if(x == N + 1){
            res++;
            return;
        }
        if(y == M + 1) {
            dfs(x + 1, 1);
            return;
        }
        if(map[x][y-1] && map[x-1][y] && map[x-1][y-1]) dfs(x, y + 1);
        else{
            dfs(x, y + 1);
            map[x][y] = true;
            dfs(x, y + 1);
            map[x][y] = false;
        }
    }
}
