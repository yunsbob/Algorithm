import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int res = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == b && b == c) {
				res = Math.max(res, 10000 + a * 1000);
			} else if (a == b) {
				res = Math.max(res, 1000 + a * 100);
			} else if (b == c) {
				res = Math.max(res, 1000 + b * 100);
			} else if (a == c) {
				res = Math.max(res, 1000 + a * 100);
			} else if (a >= b && a >= c) {
				res = Math.max(res, a * 100);
			} else if (b >= a && b >= c) {
				res = Math.max(res, b * 100);
			} else {
				res = Math.max(res, c * 100);
			}
		}

		System.out.println(res);
	}
}