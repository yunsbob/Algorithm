import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		long sum = 0, xor = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());

			if (order == 1) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				xor = xor ^ num;
			} else if (order == 2) {
				int num = Integer.parseInt(st.nextToken());
				sum -= num;
				xor = xor ^ num;
			} else if (order == 3) {
				sb.append(sum).append('\n');
			} else {
				sb.append(xor).append('\n');
			}
		}

		System.out.println(sb);
	}
}