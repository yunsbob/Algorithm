package everyday.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16398 {
	static int N;
	static int[] parents;
	static List<List<Vertex>> list = new ArrayList<>();
	
	private static class Vertex{
		int to, w;

		private Vertex(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
	       	list.add(new ArrayList<>());
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i; j++) {
				int w = Integer.parseInt(st.nextToken());
				list.get(i).add(new Vertex(j, w));
				list.get(j).add(new Vertex(i, w));
			}
		}
		
		System.out.println(getMST());
	}
	
	private static long getMST() {
		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Vertex(1, 0));
		
		int cnt = 0;
		long cost = 0;
		boolean[] check = new boolean[N + 1];
		while(!pq.isEmpty()) {
			Vertex from = pq.poll();
			if(check[from.to]) continue;
			check[from.to] = true;
			cost += from.w;
			cnt++;
			if(cnt == N) break;
			for(Vertex e : list.get(from.to)) {
				if(!check[e.to]) {
					pq.offer(e);
				}
			}
		}
		
		return cost;
	}
}