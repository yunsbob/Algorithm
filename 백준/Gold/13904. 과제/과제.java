import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Assignment implements Comparable<Assignment> {
		int d, w;

		public Assignment(int d, int w) {
			this.d = d;
			this.w = w;
		}


		@Override
		public int compareTo(Assignment o) {
			return o.w - this.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Assignment> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Assignment(d, w));
		}

		boolean[] check = new boolean[N + 1];
		int res = 0;
		for (int i = 0; i < N; i++) {
			Assignment now = pq.poll();
			
			if (now.d > N) {
				now.d = N;
			}
			
			for (int j = now.d; j >= 1; j--) {
				if (!check[j]) {
					check[j] = true;
					res += now.w;
					break;
				}
			}
		}

		System.out.println(res);
	}
}