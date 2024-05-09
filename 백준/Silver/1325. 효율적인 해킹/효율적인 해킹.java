import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int[] cnt;
	private static boolean[] visited;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		cnt = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.get(A).add(B);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i);
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, cnt[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (cnt[i] == res)
				sb.append(i).append(' ');
		}

		System.out.println(sb);
	}

	private static void dfs(int now) {
		visited[now] = true;

		for (int next : list.get(now)) {
			if (!visited[next]) {
				cnt[next]++;
				dfs(next);
			}
		}
	}
}