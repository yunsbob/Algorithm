import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] A, B;
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new boolean[N][M];
		B = new boolean[N][M];

		input(A, br);
		input(B, br);

		int res = 0;
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (A[i][j] != B[i][j]) {
					res++;
					changeMatrix(i, j);
				}
			}
		}

		A: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					res = -1;
					break A;
				}
			}
		}

		System.out.println(res);
	}

	public static void input(boolean[][] arr, BufferedReader br) throws IOException {
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				if (in.charAt(j) == '1') {
					arr[i][j] = true;
				}
			}
		}
	}

	public static void changeMatrix(int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				A[i][j] = !A[i][j];
			}
		}
	}
}