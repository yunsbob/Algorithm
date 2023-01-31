import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class TwoOneSevenEight {
	static int[][] graph;
	static Queue<Integer> queueY = new LinkedList<>();
    static Queue<Integer> queueX = new LinkedList<>();
	static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] search;

	public static void BFS() {
        StringBuilder sb = new StringBuilder();
        int nodeX, nodeY, x, y;
        queueX.offer(0);
        queueY.offer(0);
        search[0][0] = 1;
		while(!queueY.isEmpty()) {
			nodeX = queueX.poll();
            nodeY = queueY.poll();
			for(int i = 0; i < 4; i++) {
                x = nodeX + dx[i];
                y = nodeY + dy[i];
                if(x >= 0 && y >= 0 && x < M && y < N && graph[y][x] == 1){
                    queueX.offer(x);
                    queueY.offer(y);
                    graph[y][x] = 0;
                    search[y][x] = search[nodeY][nodeX] + 1;
                    if(y == N - 1 && x == M - 1){
                        sb.append(search[y][x]);
                        System.out.println(sb);
                        System.exit(0);
                    }
                }
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
        search = new int[N][M];

		for(int y = 0; y < N; y++) {
			String num = br.readLine();
            for(int x = 0; x < M; x++){
                graph[y][x] = num.charAt(x) - '0';
            }
		}
        BFS();
	}
}