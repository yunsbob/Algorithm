package everyday.prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ30646 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long[] pSum = new long[N + 1];
		Map<Integer, Integer> idxes = new HashMap<>();
		Map<Long, Integer> cnt = new HashMap<>();

		long res = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pSum[i] = pSum[i - 1] + num;

			if (!idxes.containsKey(num)) idxes.put(num, i);

			long sum = pSum[i] - pSum[idxes.get(num) - 1];
			cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);

			res = Math.max(res, sum);
		}

		System.out.println(res + " " + cnt.get(res));
	}
}