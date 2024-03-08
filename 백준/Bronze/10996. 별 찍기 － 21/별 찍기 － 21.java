import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N * 2; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < N; j++) {
					sb.append(j % 2 == 0 ? '*' : ' ');
				}
			} else {
				for (int j = 0; j < N; j++) {
					sb.append(j % 2 == 1 ? '*' : ' ');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}