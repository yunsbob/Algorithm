import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		StringBuilder input = new StringBuilder(br.readLine()).reverse();
		st = new StringTokenizer(input.toString());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				dq.addFirst(i);
			} else if (num == 2) {
				int tmp = dq.pollFirst();
				dq.addFirst(i);
				dq.addFirst(tmp);
			} else {
				dq.addLast(i);
			}
		}

		while (!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(' ');
		}

		System.out.println(sb);
	}
}