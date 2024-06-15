import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int now = 1;
		Deque<Integer> stack = new ArrayDeque<>();
		stack.offer(1001);
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (now == num) {
				now++;

				while (stack.peekLast() == now) {
					stack.pollLast();
					now++;
				}
			} else if (num < stack.peekLast()) {
				stack.offerLast(num);
			} else {
				break;
			}

			if (i == N) {
				System.out.println("Nice");
				System.exit(0);
			}
		}

		System.out.println("Sad");
	}
}