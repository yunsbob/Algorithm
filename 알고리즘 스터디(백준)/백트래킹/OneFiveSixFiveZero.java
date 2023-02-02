import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneFiveSixFiveZero {
	static int[] result;
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
			result[cnt] = i;
			DFS(i + 1, cnt + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		
		DFS(1, 0);
		
		System.out.println(sb);
	}
}