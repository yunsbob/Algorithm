import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Assignment {
		int day, end;

		public Assignment(int day, int end) {
			this.day = day;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Assignment> pq = new PriorityQueue<>(((o1, o2) -> o2.end - o1.end));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int res = Integer.MAX_VALUE;
		while (!pq.isEmpty()) {
			Assignment now = pq.poll();

			if (res > now.end) {
				res = now.end - now.day;
			} else {
				res -= now.day;
			}
		}

		System.out.println(res);
	}
}