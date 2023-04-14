package study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {
	static List<SnT> list = new ArrayList<>();
	
	private static class SnT{
		int S, T;
		private SnT(int s, int t) {
			this.S = s;
			this.T = t;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list.add(new SnT(s, t));
		}
		
		Collections.sort(list, (o1, o2) -> { 
			if(o1.S == o2.S) return Integer.compare(o1.T, o2.T);
			else return Integer.compare(o1.S, o2.S); 
		});
		
		PriorityQueue<SnT> pq = new PriorityQueue<>((o1, o2) -> o1.T - o2.T);
		int res = 0;
		for(int i = 0; i < N; i++) {
			while(!pq.isEmpty() && pq.peek().T <= list.get(i).S) {
				pq.poll();
			}
			pq.offer(list.get(i));
			res = Math.max(res, pq.size());
		}
		
		System.out.println(res);
	}
}
