package everyday.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long res1 = five(N) - five(N - M) - five(M);
		long res2 = two(N) - two(N - M) - two(M);

		System.out.println(Math.min(res1, res2));
	}

	private static long five(long N) {
		int res = 0;

		while (N >= 5) {
			res += (N / 5);
			N /= 5;
		}

		return res;
	}

	private static long two(long N) {
		int res = 0;

		while (N >= 2) {
			res += (N / 2);
			N /= 2;
		}

		return res;
	}

}