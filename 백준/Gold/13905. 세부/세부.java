import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	private static int N;
	private static List<List<Node>> list = new ArrayList<>();

	private static class Node implements Comparable<Node> {
		int num, cost;

		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, cost));
			list.get(b).add(new Node(a, cost));
		}

		System.out.println(prim(s, e));
	}

	private static long prim(int s, int e) {
		int res = 1_000_000;
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 1_000_000));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.num])
				continue;

			res = Math.min(res, now.cost);

			if (now.num == e)
				return res;

			visited[now.num] = true;

			for (Node next : list.get(now.num)) {
				if (visited[next.num])
					continue;

				pq.offer(next);
			}
		}

		return 0;
	}
}