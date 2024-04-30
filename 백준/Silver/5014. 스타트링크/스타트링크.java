import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int F, S, G, U, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		int res = 0;
		if (S != G)
			res = bfs();
		
		System.out.println(res == -1 ? "use the stairs" : res);
	}

	private static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[F + 1];
		q.offer(S);
		visited[S] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			int next = now + U;
			if (next <= F && visited[next] == 0) {
				if (next == G)
					return visited[now];

				visited[next] = visited[now] + 1;
				q.offer(next);
			}

			next = now - D;
			if (next > 0 && visited[next] == 0) {
				if (next == G)
					return visited[now];

				visited[next] = visited[now] + 1;
				q.offer(next);
			}
		}

		return -1;
	}
}