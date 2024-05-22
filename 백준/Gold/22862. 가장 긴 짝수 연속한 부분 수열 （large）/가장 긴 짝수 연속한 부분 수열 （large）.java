import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) % 2;
		}

		int res = 0, cnt = 0, s = 0, e = 0;
		while (e < N) {
			if (arr[e] == 0) {
				e++;
				res = Math.max(res, e - s - cnt);
			} else {
				cnt++;

				if (cnt <= K) {
					res = Math.max(res, e - s - cnt);
				} else {
					while (cnt > K) {
						if (arr[s++] == 1) {
							cnt--;
						}
					}
				}

				e++;
			}
		}

		System.out.println(res);
	}
}