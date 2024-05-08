import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			System.exit(0);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 1; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int res = 0;
		while (pq.peek() >= E) {
			int now = pq.poll();
			now--;
			res++;
			E++;
			pq.offer(now);
		}

		System.out.println(res);
	}
}