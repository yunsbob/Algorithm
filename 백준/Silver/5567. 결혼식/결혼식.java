import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] check = new boolean[n + 1];
		check[1] = true;
		q.offer(1);
		int cnt = 0;
		int res = 0;
		while (true) {
			int size = q.size();

			while (size-- > 0) {
				int now = q.poll();

				for (int next : list.get(now)) {
					if (check[next])
						continue;
					check[next] = true;
					q.offer(next);
					res++;
				}
			}

			if (q.isEmpty()) break;
			cnt++;
			if (cnt == 2) break;
		}
        
		return res;
	}
}