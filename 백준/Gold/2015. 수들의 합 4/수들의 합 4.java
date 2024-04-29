import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] sum = new int[N];

		st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		long res = 0;
		for (int i = 0; i < N; i++) {
			res += hm.getOrDefault(sum[i] - K, 0);
			hm.put(sum[i], hm.getOrDefault(sum[i], 0) + 1);
		}

		System.out.println(res);
	}
}