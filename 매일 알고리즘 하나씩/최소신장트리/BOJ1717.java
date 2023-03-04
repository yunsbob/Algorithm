package everyday.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
	static int n, m;
	static int[] parents;
	
	static void makeSet() {
		for(int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return;
		parents[rootB] = rootA;
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	parents = new int[n+1];
    	makeSet();
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		if(st.nextToken().equals("0")) {
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			union(a, b);
    		}
    		else {
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			if(find(a) == find(b)) {
    				sb.append("YES").append('\n');
    			}
    			else {
    				sb.append("NO").append('\n');
    			}
    		}
    	}
    	System.out.println(sb);
	}
}
