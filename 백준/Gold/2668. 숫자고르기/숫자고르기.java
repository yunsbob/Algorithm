import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	private static int N;
	private static int[] arr;
	private static boolean[] visited;
	private static List<Integer> list = new ArrayList<>();
	private static Set<Integer> check = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (check.contains(i)) continue;
			dfs(i, i);
		}

		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for (int res : list) {
			sb.append(res).append('\n');
		}
		System.out.println(sb);
	}

	private static boolean dfs(int now, int start) {
		if (visited[now]) {
			if (now == start) {
				return true;
			}
			return false;
		}
		
		visited[now] = true;
		if (dfs(arr[arr[now]], start)) {
			check.add(now);
			list.add(now);
			return true;
		}

		visited[now] = false;
		return false;
	}
}