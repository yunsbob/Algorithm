import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class OneThreeEightNine {
	static boolean[] visited;
	static boolean[][] graph;
	static Queue<Integer> queue = new LinkedList<>();
	static int[] count;

	public static void BFS(int node) {
		visited[node] = true;
		queue.offer(node);
		while(!queue.isEmpty()) {
			node = queue.poll();
			for(int i = 1; i < visited.length; i++) {
				if(graph[node][i] && !visited[i]) {
					visited[i] = true;
					count[i] += count[node] + 1;
					queue.offer(i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new boolean[N+1][N+1];

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = true;
		}

		int result = 0;
		int resultCnt = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			visited = new boolean[N+1];
			count = new int[N+1];
			BFS(i);
			for(int num : count){
				cnt += num;
			}
			if(resultCnt > cnt) {
				resultCnt = cnt;
				result = i;
			}
		}
		sb.append(result);
		System.out.println(sb);
	}
}