import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Deque<String> dq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String m = st.nextToken();
			if (m.equals("1")) {
				dq.addFirst(st.nextToken());
			} else if (m.equals("2")) {
				dq.addLast(st.nextToken());
			} else if (m.equals("3")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollFirst()).append('\n');
				}
			} else if (m.equals("4")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollLast()).append('\n');
				}
			} else if (m.equals("5")) {
				sb.append(dq.size()).append('\n');
			} else if (m.equals("6")) {
				if (dq.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if (m.equals("7")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekFirst()).append('\n');
				}
			} else if (m.equals("8")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekLast()).append('\n');
				}
			}
		}

		System.out.println(sb);
	}
}