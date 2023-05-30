package everyday.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2887 {
	static int N;
	static int[] parents;
	static List<Edge> edgelist = new ArrayList<>();
	
	private static class Planet{
		int num, x, y, z;

		private Planet(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}
	
	private static class Edge{
		int from, to, w;

		private Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		List<Planet> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Planet(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.x, o2.x));
		for(int i = 0; i < N - 1; i++) {
			edgelist.add(new Edge(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).x - list.get(i + 1).x)));
		}
		
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.y, o2.y));
		for(int i = 0; i < N - 1; i++) {
			edgelist.add(new Edge(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).y - list.get(i + 1).y)));
		}
		
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.z, o2.z));
		for(int i = 0; i < N - 1; i++) {
			edgelist.add(new Edge(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).z - list.get(i + 1).z)));
		}
		
		System.out.println(getMST());
		
	}
	
	private static int getMST() {
		int res = 0, cnt = 0;
		
		makeSet();
		Collections.sort(edgelist, (o1, o2) -> Integer.compare(o1.w, o2.w));
		
		for(Edge e : edgelist) {
			if(union(e.from, e.to)) {
				res += e.w;
				cnt++;
				if(cnt == N - 1) return res;
			}
		}
		
		return 0;
	}

	private static void makeSet() {
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		parents[b] = a;
		return true;
	}

}
