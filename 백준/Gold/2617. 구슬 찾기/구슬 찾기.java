import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = -1;
		}

		floyd();

		int[] cnt1 = new int[N + 1];
		int[] cnt2 = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (arr[i][j] == 1)
					cnt1[i]++;
				if (arr[i][j] == -1)
					cnt2[i]++;
			}
		}

		int half = (N + 1) / 2;
		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (cnt1[i] >= half)
				res++;
			if (cnt2[i] >= half)
				res++;
		}

		System.out.println(res);
	}

	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;

				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;

					if (arr[j][k] != 0 && arr[i][k] == arr[k][j])
						arr[i][j] = arr[i][k];
				}
			}
		}
	}
}