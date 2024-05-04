import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	private static int N;
	private static long sum = 0;
	private static int[] parents;
	private static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

	private static class Edge implements Comparable<Edge> {
		int a, b, cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;

			sum += cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pq.offer(new Edge(a, b, cost));
		}

		System.out.println(kruskal());
	}

	private static void makeSet() {
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;

		return parents[x] = find(parents[x]);
	}

	private static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);

		if (parentA == parentB)
			return false;

		parents[parentA] = parentB;
		return true;
	}

	private static long kruskal() {
		int cnt = 0;
		long res = 0;

		makeSet();

		while (!pq.isEmpty()) {
			Edge now = pq.poll();

			if (union(now.a, now.b)) {
				cnt++;
				res += now.cost;
			}

			if (cnt == N - 1)
				break;
		}

		if (cnt != N - 1)
			return -1;

		return sum - res;
	}
}