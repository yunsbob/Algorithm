package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {
	static Map<Integer, Integer> laddake = new HashMap<>();
	static int[] visited = new int[100];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int	M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			laddake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		BFS();
	}

	private static void BFS() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		int now;
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[1] = 0;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int i = 1; i <= 6; i++) {
				if(now + i >= 100) {
					System.out.println(visited[now] + 1);
					System.exit(0);
				}
				if(visited[now + i] > visited[now] + 1) {
					if(laddake.containsKey(now + i)) {
						if(visited[laddake.get(now + i)] > visited[now] + 1) {
							visited[now + i] = visited[now] + 1;
							visited[laddake.get(now + i)] = visited[now + i];
							q.offer(laddake.get(now + i));
						}
					}
					else {
						visited[now + i] = visited[now] + 1;
						q.offer(now + i);
					}
				}
			}
		}
	}
}