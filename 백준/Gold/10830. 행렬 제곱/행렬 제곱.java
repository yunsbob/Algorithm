import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] res = pow(B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(res[i][j] % 1000).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static int[][] pow(long cnt) {
		if (cnt == 1) {
			return matrix;
		}

		int[][] A = pow(cnt / 2);

		if (cnt % 2 == 0) {
			return cal(A, A);
		} else {
			return cal(A, cal(A, matrix));
		}
	}

	private static int[][] cal(int[][] A, int[][] B) {
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[i][j] += (A[i][k] * B[k][j]);
					arr[i][j] %= 1000;
				}
			}
		}

		return arr;
	}
}