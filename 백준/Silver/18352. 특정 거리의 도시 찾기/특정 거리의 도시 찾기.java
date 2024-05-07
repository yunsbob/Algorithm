import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dis;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) + 1;
		int X = Integer.parseInt(st.nextToken());

		dis = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}

		if (bfs(X, K)) {
			System.out.println(-1);
		} else {
			for (int i = 1; i <= N; i++) {
				if (dis[i] == K) {
					sb.append(i).append('\n');
				}
			}

			System.out.print(sb);
		}
	}

	private static boolean bfs(int X, int K) {
		Queue<Integer> q = new ArrayDeque<>();
		dis[X] = 1;
		q.offer(X);

		while (!q.isEmpty()) {
			int now = q.poll();

			if (dis[now] == K)
				return false;

			for (int next : list.get(now)) {
				if (dis[next] == 0) {
					dis[next] = dis[now] + 1;
					q.offer(next);
				}
			}
		}

		return true;
	}
}