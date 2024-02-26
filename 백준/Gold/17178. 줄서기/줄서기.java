import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class T implements Comparable<T> {
		char alpha;
		int num;

		T(char alpha, int num) {
			this.alpha = alpha;
			this.num = num;
		}

		@Override
		public int compareTo(T o) {
			if (this.alpha < o.alpha) {
				return -1;
			} else if (this.alpha > o.alpha) {
				return 1;
			} else {
				if (this.num < o.num) {
					return -1;
				} else {
					return 1;
				}
			}
		}

		public boolean equals(T o) {
			return this.alpha == o.alpha && this.num == o.num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<T> list = new ArrayList<>();
		Queue<T> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken(), "-");

				T t = new T(st2.nextToken().charAt(0), Integer.parseInt(st2.nextToken()));
				list.add(t);
				q.add(t);
			}
		}

		Collections.sort(list);

		Deque<T> stack = new ArrayDeque<>();
		int idx = 0, end = N * 5;
		while (true) {
			T now = q.poll();

			if (now.equals(list.get(idx))) {
				idx++;

				while (!stack.isEmpty() && stack.peekLast().equals(list.get(idx))) {
					stack.pollLast();
					idx++;
				}
			} else {
				stack.offerLast(now);
			}

			if (idx < end && q.isEmpty()) {
				System.out.println("BAD");
				System.exit(0);
			} else if (idx == end) {
				break;
			}
		}

		System.out.println("GOOD");
	}
}