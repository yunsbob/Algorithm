import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, (o1, o2) -> { return o1[0] - o2[0]; });

			int res = 1;
			int cut = arr[0][1];
			for (int j = 1; j < N; j++) {
				if (arr[j][1] < cut) {
					res++;
					cut = arr[j][1];
				}
			}

			sb.append(res).append('\n');
		}

		System.out.println(sb);
	}
}