import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] order;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		order = new int[N];
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

		if (order[0] != 1) System.out.println(0);
		else System.out.println(bfs() ? 1 : 0);
	}

	private static boolean bfs() {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		int idx = 1, cnt = 1;
		visited[1] = true;
		q.offer(1);

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {
				if (visited[next]) continue;
				visited[next] = true;
				cnt++;
			}

			while (idx != cnt) {
				if (!visited[order[idx]]) return false;
				q.offer(order[idx]);
				idx++;
			}
		}

		return true;
	}
}