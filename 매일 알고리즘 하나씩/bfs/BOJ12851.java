package everyday.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ12851 {
	static int visited[] = new int[100001];
    static int N, K, cnt = 0;

	private static void BFS(int node){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		int n, time = 100001;
		int[] dx = {1, -1, 2};
		int mX;
		visited[node] = 1;

		while (!queue.isEmpty()) {
			n = queue.poll();
			
			if(time < visited[n]){
				return;
			}
			if (n == K) {
				time = visited[n];
				cnt++;
				continue;
			}
			for(int i = 0; i < 3; i++){
				if(i == 2){
					mX = n * dx[i];
				}
				else{
					mX = n + dx[i];
				}
				if(mX >= 0 && mX <= 100000 && (visited[mX] == 0 || visited[mX] == visited[n] + 1)){
					queue.offer(mX);
					visited[mX] = visited[n] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		BFS(N);
        sb.append(visited[K] - 1).append('\n').append(cnt);
        System.out.println(sb);
	}
}