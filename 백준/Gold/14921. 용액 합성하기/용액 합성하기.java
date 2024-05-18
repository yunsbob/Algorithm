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
		int l = 0, r = N - 1, res = 200_000_001;
		while (l < r) {
			int sum = arr[l] + arr[r];

			if (Math.abs(res) > Math.abs(sum))
				res = sum;

			if (res == 0)
				break;

			if (sum < 0) {
				l++;
			} else {
				r--;
			}
		}

		System.out.println(res);
 	}
}