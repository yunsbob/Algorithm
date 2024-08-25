import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] w = new int[N];
		int res = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(st.nextToken());

			if (w[i] == C) {
				res = 1;
				break;
			}
		}

		if (res == 0) {
			Arrays.sort(w);

			int s = 0, e = N - 1;
			A: while (s < e) {
				int now = w[s] + w[e];

				if (now > C) {
					e--;
				} else if (now == C) {
					res = 1;
					break;
				} else {
					int l = s + 1, r = e - 1, k = C - now;
					while (l <= r) {
						int mid = (l + r) / 2;
						if (w[mid] == k) {
							res = 1;
							break A;
						} else if (w[mid] < k) {
							l = mid + 1;
						} else {
							r = mid - 1;
						}
					}

					s++;
				}
			}
		}

		System.out.println(res);
	}
}