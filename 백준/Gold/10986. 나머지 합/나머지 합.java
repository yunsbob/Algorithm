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
		long[] cnt = new long[M];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum = (Integer.parseInt(st.nextToken()) + sum) % M;
			cnt[sum]++;
		}

		long res = cnt[0];
		for (int i = 0; i < M; i++) {
			res += cnt[i] * (cnt[i] - 1) / 2;
		}

		System.out.println(res);
	}
}