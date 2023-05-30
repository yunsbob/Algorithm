package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static boolean [][] visited, graph;
    static int N, M;

    public static void dfs(int y, int x){
        visited[y][x] = true;
        
        if(x + 1 < M && !visited[y][x+1] && graph[y][x+1]){
            dfs(y, x + 1);
        }
        if(y + 1 < N && !visited[y+1][x] && graph[y+1][x]){
            dfs(y + 1, x);
        }
        if(x - 1 >= 0 && !visited[y][x-1] && graph[y][x-1]){
            dfs(y, x - 1);
        }
        if(y - 1 >= 0 && !visited[y-1][x] && graph[y-1][x]){
            dfs(y - 1, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            graph = new boolean[N][M];
            visited = new boolean[N][M];
            int K = Integer.parseInt(st.nextToken());

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = true;
            }
            
            int result = 0;
            for(int y = 0; y < N; y++){
                for(int x = 0; x < M; x++){
                    if(!visited[y][x] && graph[y][x]){
                        result++;
                        dfs(y, x);
                    }
                }
            }
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}