package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(br.readLine()));
		}
		
		long sum = 0, n, m;	

		while(pq.size() > 1) {
			n = pq.poll();
			m = pq.poll();
			sum += n + m;
			pq.offer(n + m);
		}

		System.out.println(sum);
	}

}
