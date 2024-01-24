import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, L, res = 0;
	private static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			check(i, true);
			check(i, false);
		}

		System.out.println(res);
	}

	private static void check(int now, boolean rc) {
		int[] h = new int[N];
		boolean[] ramp = new boolean[N];
		if (rc) {
			for (int i = 0; i < N; i++) {
				h[i] = map[now][i];
			}
		} else {
			for (int i = 0; i < N; i++) {
				h[i] = map[i][now];
			}
		}

		for (int i = 0; i < N - 1; i++) {
			if (h[i] != h[i + 1]) {
			 	if (h[i] == h[i + 1] + 1) {
					 if (i + L >= N) return;
					 for (int j = i + 1; j <= i + L; j++) {
						 if (h[i + 1] != h[j] || ramp[j]) return;
						 ramp[j] = true;
					 }
				} else if (h[i] == h[i + 1] - 1) {
					 if (i - L + 1 < 0) return;
					 for (int j = i; j > i - L; j--) {
						 if (h[i] != h[j] || ramp[j]) return;
						 ramp[j] = true;
					 }
				} else return;
			}
		}

		res++;
	}
}