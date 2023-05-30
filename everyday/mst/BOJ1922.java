package everyday.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922 {
	static int V, E;
	static List<List<Edge>> list = new ArrayList<>();
	
	static class Edge {
		int to, weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.offer(new Edge(1, 0));
		
		int cnt = 0;
		int cost = 0;
		boolean[] check = new boolean[V + 1];
		while(!pq.isEmpty()) {
			Edge from = pq.poll();
			if(check[from.to]) continue;
			check[from.to] = true;
			cost += from.weight;
			cnt++;
			if(cnt == V) break;
			for(Edge e : list.get(from.to)) {
				if(!check[e.to]) {
					pq.offer(e);
				}
			}
		}
		return cost;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= V; i++) {
        	list.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	list.get(from).add(new Edge(to, weight));
        	list.get(to).add(new Edge(from, weight));  	
        }
        System.out.println(prim());
	}
}