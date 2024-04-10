import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static class City {
		int cost, customer;

		public City(int cost, int customer) {
			this.cost = cost;
			this.customer = customer;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken()) + 101;
		int N = Integer.parseInt(st.nextToken());
		List<City> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			list.add(new City(cost, customer));
		}

		int[] dp = new int[C];
		Arrays.fill(dp, 100_001);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			int cost = list.get(i).cost;
			int customer = list.get(i).customer;
			for (int j = customer; j < C; j++) {
				if (dp[j - customer] != 100_001)
					dp[j] = Math.min(dp[j], dp[j - customer] + cost);
			}
		}

		int res = 100_001;
		for (int i = C - 101; i < C; i++) {
			res = Math.min(res, dp[i]);
		}

		System.out.println(res);
	}
}