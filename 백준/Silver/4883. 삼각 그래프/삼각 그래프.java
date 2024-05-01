import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			int[][] arr = new int[N][3];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				arr[0][i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					arr[1][i] = arr[0][1] + Integer.parseInt(st.nextToken());
				} else{
					arr[1][i] = Math.min(arr[1][i - 1], Math.min(arr[0][1], arr[0][1] + arr[0][2])) + Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 2; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 3; j++) {
					if (j == 0) {
						arr[i][j] = Math.min(arr[i - 1][0], arr[i - 1][1]) + Integer.parseInt(st.nextToken());
					} else if (j == 1) {
						arr[i][j] = Math.min(Math.min(arr[i - 1][0], arr[i - 1][1]), Math.min(arr[i - 1][2], arr[i][0]))
							+ Integer.parseInt(st.nextToken());
					} else {
						arr[i][j] = Math.min(arr[i - 1][1], Math.min(arr[i - 1][2], arr[i][1]))
							+ Integer.parseInt(st.nextToken());
					}
				}
			}

			sb.append(t++).append(". ").append(arr[N - 1][1]).append('\n');
		}

		System.out.println(sb);
	}
}