import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int N, idx = 0;
	private static boolean flag = true;
	private static int[] order;
	private static boolean[] visited;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		order = new int[N];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}

		if (order[0] == 1) dfs(1);
		else flag = false;

		System.out.println(flag ? 1 : 0);
	}

	private static void dfs(int now) {
		if (visited[now]) return;
		visited[now] = true;
		idx++;

		Set<Integer> hs = new HashSet<>();
		for (int next : list.get(now)) {
			if (!visited[next]) hs.add(next);
		}

		if (hs.size() == 0) return;

		if (hs.contains(order[idx])) dfs(order[idx]);
		else flag = false;
	}
}