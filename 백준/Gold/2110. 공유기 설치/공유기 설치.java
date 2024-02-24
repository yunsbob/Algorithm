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
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int min = 1, max = arr[N - 1] - arr[0];
		while (min <= max) {
			int mid = (min + max) / 2;

			int cnt = 1;
			int last = arr[0];
			for (int i = 1; i < N; i++) {
				int now = arr[i];

				if (now - last >= mid) {
					cnt++;
					last = now;
				}
			}

			if (cnt < C) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
	}
}