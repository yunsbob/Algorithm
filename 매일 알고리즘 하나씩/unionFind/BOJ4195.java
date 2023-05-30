package everyday.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ4195 {
	static int N;
	static int[] parents;
	static int[] friendsNum;
	static Map<String, Integer> friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			makeSet();
			
			int idx = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(!friends.containsKey(a)) friends.put(a, idx++);
				if(!friends.containsKey(b)) friends.put(b, idx++);
				sb.append(union(friends.get(a), friends.get(b))).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	private static void makeSet() {
		friends = new HashMap<>();
		parents = new int[N * 2 + 1];
		friendsNum = new int[N * 2 + 1];
		for(int i = 0; i <= N * 2; i++) {
			parents[i] = i;
			friendsNum[i] = 1;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return friendsNum[a];
		parents[b] = a;
		friendsNum[a] += friendsNum[b];
		friendsNum[b] = friendsNum[a];
		return friendsNum[a];
	}
}
