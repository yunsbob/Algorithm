import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		long res = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > 0)
				break;

			int s = i + 1, e = N - 1;
			while (s < e) {
				int sum = arr[i] + arr[s] + arr[e];
				if (sum == 0) {
					int lCnt = 1, rCnt = 1;
					if (arr[s] == arr[e]) {
						int c = e - s + 1;
						res += c * (c - 1) / 2;
						break;
					}

					while (arr[s] == arr[s + 1]) {
						lCnt++;
						s++;
					}

					while (arr[e] == arr[e - 1]) {
						rCnt++;
						e--;
					}

					res += lCnt * rCnt;
				}

				if (sum > 0)
					e--;
				else
					s++;
			}
		}

		System.out.println(res);
	}
}