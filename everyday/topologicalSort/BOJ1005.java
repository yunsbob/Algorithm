package everyday.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {
	static int N, M, end;
	static int[] endV, time;
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			endV = new int[N+1];
			time = new int[N+1];
			visited = new boolean[N+1];
			list.clear();
			
			list.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				list.add(new ArrayList<>());
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list.get(start).add(end);
				endV[end]++;
			}
			
			end = Integer.parseInt(br.readLine());
			
			topoSort();
		}
		System.out.println(sb);
	}

	private static void topoSort() {
		Queue<Integer> q = new ArrayDeque<>();
		int[] dp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			dp[i] = time[i];
			if(endV[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Integer v : list.get(now)) {
				endV[v]--;
				dp[v] = Math.max(dp[v], dp[now] + time[v]);
				if(endV[v] == 0) {
					q.offer(v);
				}
			}
		}
		sb.append(dp[end]).append('\n');
	}
}