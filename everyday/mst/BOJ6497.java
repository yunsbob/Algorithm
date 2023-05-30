package everyday.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6497 {
	static int m;
	static List<List<Path>> list = new ArrayList<>();	
	static class Path{
		int to, w;

		Path(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
	}

	static int prim() {
		PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
		pq.offer(new Path(0, 0));
		
		int cnt = 0;
		int cost = 0;
		boolean[] check = new boolean[m + 1];
		while(!pq.isEmpty()) {
			Path from = pq.poll();
			if(check[from.to]) continue;
			check[from.to] = true;
			cost += from.w;
			cnt++;
			if(cnt == m) break;
			for(Path e : list.get(from.to)) {
				if(!check[e.to]) {
					pq.offer(e);
				}
			}
		}
		return cost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		while(true) {
			int result = 0;
			list.clear();
			
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0) break;
			
			for(int i = 0; i < m; i++) {
				list.add(new ArrayList<>());
			}
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list.get(from).add(new Path(to, w));
				list.get(to).add(new Path(from, w));
				result += w;
			}
			sb.append(result - prim()).append('\n');
		}
		System.out.println(sb);
	}
}