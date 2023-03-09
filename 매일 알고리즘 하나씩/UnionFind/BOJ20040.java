package everyday.UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ20040 {
	static int N;
    static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		int res = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			res++;
			if(union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) break;
			if(i == M - 1) res = 0;
		}
		System.out.println(res);
	}
	
	private static void makeSet() {
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++) {
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
		if(a == b) return true;
		parents[a] = b;
		return false;
	}
}