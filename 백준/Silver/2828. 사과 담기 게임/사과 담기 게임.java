import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()) - 1;
		int J = Integer.parseInt(br.readLine());

		int l = 1, r = M + 1, res = 0;
		for (int i = 0; i < J; i++) {
			int x = Integer.parseInt(br.readLine());

			if (r < x) {
				res += x - r;
				r = x;
				l = r - M;
			} else if (x < l) {
				res += l - x;
				l = x;
				r = l + M;
			}
		}

		System.out.println(res);
	}
}