package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6118 {
	private static int N, num, dis, cnt;
	private static List<List<Integer>> connection = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			connection.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			connection.get(A).add(B);
			connection.get(B).add(A);
		}

		BFS();

		System.out.println(num + " " + dis + " " + cnt);
	}

	private static void BFS() {
		int[] visited = new int[N + 1];
		Queue<Integer> q = new ArrayDeque<>();

		dis = 0;
		cnt = 0;
		visited[1] = 1;
		q.offer(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : connection.get(now)) {
				if (visited[next] != 0) continue;
				visited[next] = visited[now] + 1;

				if (visited[next] > dis) {
					num = next;
					dis = visited[next];
					cnt = 1;
				} else if (visited[next] == dis) {
					if (next < num) num = next;
					cnt++;
				}

				q.offer(next);
			}
		}

		dis--;
	}
}
