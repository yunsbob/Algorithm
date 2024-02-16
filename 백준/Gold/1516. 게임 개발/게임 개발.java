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
	private static int[] endV, times, res;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		endV = new int[N + 1];
		times = new int[N + 1];
		res = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int num = Integer.parseInt(st.nextToken());

				if (num == -1)
					break;

				list.get(num).add(i);
				endV[i]++;
			}
		}

		topoSort();

		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append('\n');
		}
		System.out.println(sb);
	}

	private static void topoSort() {
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (endV[i] == 0) {
				res[i] = times[i];
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {
				endV[next]--;
				res[next] = Math.max(res[next], res[now]);

				if (endV[next] == 0) {
					res[next] += times[next];
					q.offer(next);
				}
			}
		}
	}
}