package everyday.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22865 {
	private static int N, A, B, C;
	private static List<List<XY>> list = new ArrayList<>();

	private static class XY implements Comparable<XY>{
		int node, dist;

		public XY(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		@Override
		public int compareTo(XY o) {
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[] distA, distB, distC;
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			list.get(D).add(new XY(E, dist));
			list.get(E).add(new XY(D, dist));
		}

		distA = dijkstra(A);
		distB = dijkstra(B);
		distC = dijkstra(C);

		int res = 0, max = 0;
		for (int i = 1; i < N; i++) {
			int dist = Math.min(distA[i], Math.min(distB[i], distC[i]));
			if (max < dist) {
				max = dist;
				res = i;
			}
		}

		System.out.println(res);
	}

	private static int[] dijkstra(int start) {
		PriorityQueue<XY> pq = new PriorityQueue<>();

		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = 1_000_000_000;
		}

		dist[start] = 0;
		pq.offer(new XY(start, 0));

		while (!pq.isEmpty()) {
			XY now = pq.poll();
			if (now.dist > dist[now.node]) continue;
			for (XY next : list.get(now.node)) {
				int nextDist = now.dist + next.dist;
				if (dist[next.node] > nextDist) {
					dist[next.node] = nextDist;
					pq.offer(new XY(next.node, dist[next.node]));
				}
			}
		}

		return dist;
	}
}
