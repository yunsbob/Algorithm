import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int cnt;
	private static int[] arr;
	private static boolean[] visited, check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			check = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (!check[j]) {
					dfs(j);
				}
			}

			sb.append(n - cnt).append('\n');
		}

		System.out.println(sb);
	}

	private static void dfs(int num) {
		if (visited[num]) {
			check[num] = true;
			cnt++;
		} else {
			visited[num] = true;
		}

		if (!check[arr[num]]) {
			dfs(arr[num]);
		}

		visited[num] = false;
		check[num] = true;
	}
}