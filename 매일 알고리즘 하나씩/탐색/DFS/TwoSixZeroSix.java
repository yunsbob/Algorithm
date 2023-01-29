import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSixZeroSix {
    static boolean [] visited;
    static int[][] graph;
    static int N;
    static int result = -1;

    public static void dfs(int v){
        visited[v] = true;
        result++;
        
        for (int i = 1; i <= N; i++){
            if (graph[v][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        int M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int de = Integer.parseInt(st.nextToken());
            graph[no][de] = graph[de][no] = 1;
        }
        
        dfs(1);
        sb.append(result);
        System.out.println(sb);
    }
}