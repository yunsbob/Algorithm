package everyday.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14938 {
	static int N, M, res;
    static int[] item;
    static List<List<XY>> path = new ArrayList<>();
    
    public static class XY{
    	int x, w;

		XY(int y, int w) {
			this.x = y;
			this.w = w;
		}
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		item = new int[N+1];
		path.add(new ArrayList<>());
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			path.add(new ArrayList<>());
		}
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			path.get(start).add(new XY(end, w));
			path.get(end).add(new XY(start, w));
		}
		for(int i = 1; i <= N; i++) {
			farming(i);
		}
		System.out.println(res);
	}

	private static void farming(int start) {
		int[] distance = new int[N + 1];
		PriorityQueue<XY> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.add(new XY(start, 0));
		XY now;
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		while(!pq.isEmpty()) {
			now = pq.poll();
			for(XY next : path.get(now.x)) {
				if(distance[now.x] + next.w > M) continue;
				if(distance[next.x] > distance[now.x] + next.w) {
					distance[next.x] = distance[now.x] + next.w;
					pq.offer(new XY(next.x, distance[next.x]));
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			if(distance[i] != Integer.MAX_VALUE) {
				sum += item[i];
			}
		}
		res = Math.max(res, sum);
	}	
}