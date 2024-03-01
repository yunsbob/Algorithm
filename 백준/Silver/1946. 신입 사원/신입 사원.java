import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a] = b;
			}

			int res = 1;
			int cut = arr[1];
			for (int j = 2; j <= N; j++) {
				if (arr[j] < cut) {
					res++;
					cut = arr[j];
				}
			}

			sb.append(res).append('\n');
		}

		System.out.println(sb);
	}
}