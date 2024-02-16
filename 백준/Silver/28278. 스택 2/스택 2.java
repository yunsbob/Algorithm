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

		Deque<Integer> stack = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			char order = st.nextToken().charAt(0);
			if (order == '1') {
				stack.addLast(Integer.parseInt(st.nextToken()));
			} else if (order == '2') {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pollLast()).append('\n');
				}
			} else if (order == '3') {
				sb.append(stack.size()).append('\n');
			} else if (order == '4') {
				if (stack.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peekLast()).append('\n');
				}
			}
		}

		System.out.println(sb);
	}
}