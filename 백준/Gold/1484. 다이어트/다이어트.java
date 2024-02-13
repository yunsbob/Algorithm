import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int G = Integer.parseInt(br.readLine());
		long s = 1, e = 2;

		while (e < 100_000) {
			long before = s * s;
			long after = e * e;

			if (after - before == G) {
				sb.append(e).append('\n');
			}

			if (after - before >= G) {
				s++;
			} else {
				e++;
			}
		}

		if (sb.length() != 0) {
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}
}