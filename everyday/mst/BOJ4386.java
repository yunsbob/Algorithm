package everyday.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4386 {
	static int N;
	static int[] parents;
	static List<Edge> elist = new ArrayList<>();
	
	static class Edge{
		int from, to;
		double w;

		Edge(int from, int to, double w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		double[][] xy = new double[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			xy[i][0] = Double.parseDouble(st.nextToken());
			xy[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				double w = Math.sqrt(Math.pow(xy[i][0] - xy[j][0], 2) + Math.pow(xy[i][1] - xy[j][1], 2));
				elist.add(new Edge(i, j, w));
			}
		}
		System.out.printf("%.2f", getMST());
		
	}

	private static double getMST() {
		int cnt = 0;
		double res = 0;

		makeSet();
		Collections.sort(elist, (o1, o2) -> Double.compare(o1.w, o2.w));
		
		for(Edge e : elist) {
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
		for(int i = 1; i < N; i++) {
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