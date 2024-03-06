import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static List<List<Node>> list = new ArrayList<>();

	private static class Node {
		int n, cost;
		Node(int n, int cost) {
			this.n = n;
			this.cost = cost;
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
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list.get(A).add(new Node(B, C));
			list.get(B).add(new Node(A, C));
		}

		System.out.println(dijkstra());
	}

	private static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 50_000_000);
		dist[1] = 0;
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (Node next : list.get(now.n)) {
				if (dist[next.n] <= dist[now.n] + next.cost) continue;

				dist[next.n] = dist[now.n] + next.cost;
				pq.offer(new Node(next.n, dist[next.n]));
			}
		}

		return dist[N];
	}
}