package everyday.dfs;

import java.io.*;

public class BOJ10026 {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, cnt1, cnt2;
    
    public static void DFS(int y, int x){
        visited[y][x] = true;
        for(int i = 0; i < 4; i++){
            int mX = x + dx[i];
            int mY = y + dy[i];
            if(mX >= 0 && mY >= 0 && mX < N && mY < N && !visited[mY][mX] && map[y][x] == map[mY][mX]){
                DFS(mY, mX);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                if(str.charAt(j) == 'R'){
                    map[i][j] = 1;
                }
                else if(str.charAt(j) == 'B'){
                    map[i][j] = 2;
                }
                else if(str.charAt(j) == 'G'){
                    map[i][j] = 3;
                }
            }
        }
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(!visited[y][x]){
                    cnt1++;
                    DFS(y, x);
                }
            }
        }

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 3){
                    map[i][j] = 1;
                }
            }
        }
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(!visited[y][x]){
                    cnt2++;
                    DFS(y, x);
                }
            }
        }
        
        sb.append(cnt1 + " " + cnt2);
        System.out.println(sb);
    }
}
