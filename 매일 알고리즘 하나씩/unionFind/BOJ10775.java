package everyday.unionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ10775{
	static int G, P;
    static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		makeSet();
		
		int res = 0;
		for(int i = 0; i < P; i++) {
			int now = find(Integer.parseInt(br.readLine()));

			if (now == 0) {
				break;
			}

			res++;
			union(now, now - 1);
		}
		System.out.println(res);
	}
	
	private static void makeSet() {
		parents = new int[G + 1];
		for(int i = 1; i <= G; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		parents[a] = b;
	}
}