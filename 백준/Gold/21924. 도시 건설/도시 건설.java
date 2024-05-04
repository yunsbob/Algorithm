import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	private static int N;
	private static long sum = 0;
	private static List<List<Node>> list = new ArrayList<>();

	private static class Node implements Comparable<Node> {
		int num, cost;

		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

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

			sum += cost;
		}

		System.out.println(prim());
	}

	private static long prim() {
		long res = 0;
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.num])
				continue;

			visited[now.num] = true;
			res += now.cost;

			for (Node next : list.get(now.num)) {
				if (visited[next.num])
					continue;

				pq.offer(next);
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				return -1;
			}
		}

		return sum - res;
	}
}