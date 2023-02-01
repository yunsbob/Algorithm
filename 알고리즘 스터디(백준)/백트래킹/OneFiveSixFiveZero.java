import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneFiveSixFiveZero {
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
	
	public static void DFS(int node, int cnt) {
		if(check(cnt)) {
			return ;
		}
		
		for(int i = node; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = i;
				DFS(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		int[] arr = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		
		DFS(1, 0);
		
		System.out.println(sb);
	}
}