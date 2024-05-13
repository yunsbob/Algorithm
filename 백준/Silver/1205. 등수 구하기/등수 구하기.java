import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		if (N == 0) {
			System.out.println(1);
		} else {
			List<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(arr, Collections.reverseOrder());
			if (N == P && T <= arr.get(N - 1)) {
				System.out.println(-1);
			} else {
				for (int i = 0; i < N; i++) {
					if (arr.get(i) <= T) {
						System.out.println(i + 1);
						System.exit(0);
					}
				}

				System.out.println(N + 1);
			}
		}
	}
}