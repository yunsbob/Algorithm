import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a = 1000, b = 1000;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int inA = Integer.parseInt(st.nextToken());
			int inB = Integer.parseInt(st.nextToken());
			a = Math.min(a, inA);
			b = Math.min(b, inB);
		}

		if (b * 6 < a) {
			System.out.println(b * N);
		} else {
			int tmp = N % 6;

			if (b * tmp < a) {
				System.out.println(b * tmp + N / 6 * a);
			} else {
				System.out.println((int)Math.ceil((double)N / 6.0) * a);
			}
		}
	}
}