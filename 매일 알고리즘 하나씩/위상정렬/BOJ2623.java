package everyday.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2623 {
	static int N;
	static int[] endV;
	static List<List<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		endV = new int[N+1];
		int M = Integer.parseInt(st.nextToken());
		int m, now, next;
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			now = Integer.parseInt(st.nextToken());
			for(int j = 1; j < m; j++) {
				next = Integer.parseInt(st.nextToken());
				list.get(now).add(next);
				endV[next]++;
				now = next;
			}
		}
		
		topoSort();
		
		boolean flag = false;
		for(int i = 1; i <= N; i++) {
			if(endV[i] != 0) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println(0);
		}
		else {			
			System.out.println(sb);
		}
	}
	
	private static void topoSort() {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(endV[i] == 0) q.add(i);
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append('\n');
			for(Integer v : list.get(now)) {
				endV[v]--;
				if(endV[v] == 0) {
					q.offer(v);
				}
			}
		}
	}

}
