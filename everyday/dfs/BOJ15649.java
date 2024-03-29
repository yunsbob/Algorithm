package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
	static int[] result;
	static boolean[] visited;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static boolean check(int cnt) {
		if(cnt == M) {
			for(int num : result) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return true;
		}
		return false;
	}
	
	public static void DFS(int cnt) {
		if(check(cnt)) {
			return ;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = i;
				DFS(cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		
		DFS(0);
		
		System.out.println(sb);
	}
}