import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pollLast());
				}

				while (true) {
					sb.append(str.charAt(i));

					if (str.charAt(i) == '>')
						break;

					i++;
				}
			} else if (str.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pollLast());
				}
				sb.append(' ');
			} else {
				stack.addLast(str.charAt(i));
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}

		System.out.println(sb);
	}
}