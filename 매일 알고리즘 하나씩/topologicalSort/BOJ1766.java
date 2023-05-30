package everyday.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1766 {
	static int N, M;
	static int[] endV;
	static List<List<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		endV = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			endV[end]++;
		}
		
		topoSort();
		System.out.println(sb);
	}

	private static void topoSort() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			if(endV[i] == 0) q.add(i);
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(' ');
			for(Integer v : list.get(now)) {
				endV[v]--;
				if(endV[v] == 0) {
					q.offer(v);
				}
			}
		}
	}
}