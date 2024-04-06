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
	private static int[] endV, res;
	private static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		endV = new int[N + 1];
		res = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			list.get(A).add(B);
			endV[B]++;
		}

		topoSort();

		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append(' ');
		}

		System.out.println(sb);
	}

	private static void topoSort() {
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (endV[i] == 0) {
				res[i] = 1;
				q.offer(i);
			}
		}

		int cnt = 2;
		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				int now = q.poll();
				for (int num : list.get(now)) {
					endV[num]--;

					if (endV[num] == 0) {
						q.offer(num);
						res[num] = cnt;
					}
				}
			}

			cnt++;
		}
	}
}