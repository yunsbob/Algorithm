import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0, e = 0, sum = 0, res = 0;
		while (e < N) {
			sum += arr[e++];

			while (sum > M) {
				sum -= arr[s++];
			}

			if (sum == M) {
				res++;
				sum -= arr[s++];
			}
		}

		System.out.println(res);
	}
}