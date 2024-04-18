import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, res;
	private static List<List<Node>> list = new ArrayList<>();

	private static class Node {
		int n, d;

		public Node(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, w));
			list.get(b).add(new Node(a, w));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			res = 0;
			dfs(0, a, 0, b);
			sb.append(res).append('\n');
		}

		System.out.println(sb);
	}

	private static void dfs(int prev, int now, int dist, int end) {
		if (now == end) {
			res = dist;
		} else {
			for (Node next : list.get(now)) {
				if (prev == next.n)
					continue;

				dfs(now, next.n, dist + next.d, end);

				if (res != 0)
					return;
			}
		}
	}
}