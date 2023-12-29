package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346 {
	private static class Balloon {
		int num, cnt;

		Balloon(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Deque<Balloon> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
		}

		Balloon balloon = deque.poll();
		sb.append(balloon.num).append(' ');
		while (!deque.isEmpty()) {
			if (balloon.cnt > 0) {
				for (int i = 1; i < balloon.cnt; i++) {
					deque.offer(deque.poll());
				}
				balloon = deque.poll();
			}
			else {
				for (int i = -1; i > balloon.cnt; i--) {
					deque.offerFirst(deque.pollLast());
				}
				balloon = deque.pollLast();
			}

			sb.append(balloon.num).append(' ');
		}

		System.out.println(sb);
	}
}