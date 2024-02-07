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
		int res = 0;
		for (int i = 0; i < N; i++) {
			int s = 0, e = N - 1;
			while (s < e) {
				if (s == i) {
					s++;
					continue;
				} else if (e == i) {
					e--;
					continue;
				}

				if (arr[s] + arr[e] < arr[i]) {
					s++;
				} else if (arr[s] + arr[e] > arr[i]) {
					e--;
				} else {
					res++;
					break;
				}
			}
		}

		System.out.println(res);
	}
}