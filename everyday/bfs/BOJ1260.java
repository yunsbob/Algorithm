package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static int N, M; // 노드 수, 간선 수
    static boolean[][] E; // 간선 연결 배열
    static boolean[] visited; // 방문 처리
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int node){
        visited[node] = true; // 방문처리
        sb.append(node).append(' ');
        for(int next = 1; next <= N; next++){ // next에 방문한적 없고 현재 노드와 연결되어 있으면
            if(!visited[next] && E[node][next]){
                DFS(next);
            }
        }
    }

    public static void BFS(int node){
        visited[node] = true; // 탐색전 첫 노드 방문처리
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            node = q.poll(); // 노드 방문
            sb.append(node).append(' ');
            for(int next = 1; next <= N; next++){ // next에 방문한적 없고 현재 노드와 연결되어 있으면
                if(!visited[next] && E[node][next]){
                    visited[next] = true; // 방문 처리
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        E = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){ // 간선연결
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            E[v1][v2] = E[v2][v1] = true;
        }
        DFS(V);
        sb.append('\n');
        Arrays.fill(visited, false);
        BFS(V);
        System.out.println(sb);
    }
}
