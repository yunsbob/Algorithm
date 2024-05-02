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

		int t = Integer.parseInt(br.readLine());
		int[] arr;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			int l = 0, r = n - 1, res = 0, min = Integer.MAX_VALUE;
			while (l < r) {
				int sum = arr[l] + arr[r];
				if (Math.abs(sum - K) < min) {
					min = Math.abs(sum - K);
					res = 1;
				} else if (Math.abs(sum - K) == min) {
					res++;
				}

				if (sum == K) {
					l++;
					r--;
				} else if (sum < K) {
					l++;
				} else {
					r--;
				}
			}

			sb.append(res).append('\n');
		}

		System.out.println(sb);
	}
}