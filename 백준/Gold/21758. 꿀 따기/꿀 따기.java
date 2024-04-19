import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] left = new int[N];
		int[] right = new int[N];
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			left[i] = left[i - 1] + arr[i];
		}

		for (int i = N - 2; i >= 0; i--) {
			right[i] = right[i + 1] + arr[i];
		}

		int res = 0;
		for (int i = 1; i < N - 1; i++) {
			res = Math.max(res, left[N - 1] - arr[i] + left[N - 1] - left[i]);
		}

		for (int i = 1; i < N - 1; i++) {
			res = Math.max(res, left[i] + right[i]);
		}

		for (int i = 1; i < N - 1; i++) {
			res = Math.max(res, right[0] - arr[i] + right[0] - right[i]);
		}

		System.out.println(res);
	}
}