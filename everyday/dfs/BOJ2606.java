package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {
    static boolean[] visited; // 방문 여부
    static boolean[][] network; // 컴퓨터간 네트워크
    static int N, virus = -1; // N: 컴퓨터 수, virus: 바이러스에 걸린 컴퓨터 수

    public static void DFS(int node){
        visited[node] = true; // 현재 컴퓨터 방문
        virus++; // 바이러스에 걸린 컴퓨터 카운트
        for(int i = 1; i <= N; i++){
            if(!visited[i] && network[node][i]){ // i번 컴퓨터에 방문한적 없고 현재 컴퓨터와 연결되어 있다면
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 네트워크 수
        network = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a][b] = network[b][a] = true; // 컴퓨터간 네트워크 연결
        }

        DFS(1); // 1번 컴퓨터부터 DFS탐색
        sb.append(virus);
        System.out.println(sb);
    }
}
