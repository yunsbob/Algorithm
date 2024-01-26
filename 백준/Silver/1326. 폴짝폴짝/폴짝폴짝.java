import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, a, b;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		System.out.println(a == b ? 0 : jump(a, b));
	}

	private static int jump(int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		int cnt = 1;
		visited[start] = true;
		q.offer(start);

		while (q.size() != 0) {
			int size = q.size();
			while (size-- > 0) {
				int now = q.poll();

				if (now == end)
					return cnt;
				else if (arr[now] == 0)
					continue;
				else if ((end - now) % arr[now] == 0)
					return cnt;

				for (int i = now; i <= N; i += arr[now]) {
					if (visited[i])
						continue;
					visited[i] = true;
					q.offer(i);
				}
				for (int i = now; i >= 0; i -= arr[now]) {
					if (visited[i])
						continue;
					visited[i] = true;
					q.offer(i);
				}
			}

			cnt++;
		}

		return -1;
	}
}