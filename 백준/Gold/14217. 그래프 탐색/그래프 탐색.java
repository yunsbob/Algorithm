import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] res;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			repair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			bfs();

			sb.append(0).append(' ');
			for (int j = 2; j <= n; j++) {
				sb.append(res[j] == 0 ? -1 : res[j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void repair(int order, int a, int b) {
		if (order == 1) {
			list.get(a).add(b);
			list.get(b).add(a);
		}
		else {
			list.get(a).remove(Integer.valueOf(b));
			list.get(b).remove(Integer.valueOf(a));
		}
	}

	private static void bfs() {
		res = new int[n + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : list.get(now)) {
				if (res[next] != 0) continue;
				res[next] = res[now] + 1;
				q.offer(next);
			}
		}
	}
}