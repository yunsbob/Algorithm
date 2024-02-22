import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				StringBuilder str = new StringBuilder();
				str.append(st.nextToken());
				sb.append(str.reverse()).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}