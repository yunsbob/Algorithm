package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724 {
    static boolean[] visited;
    static boolean[][] graph;

    public static void DFS(int node){
        visited[node] = true;

        for(int i = 2; i < visited.length; i++){
            if(graph[node][i] && !visited[i]){
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        graph = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }

        int result = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                result++;
                DFS(i);
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}
