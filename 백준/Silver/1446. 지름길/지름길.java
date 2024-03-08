import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int D;
	private static int[] dp;
	private static HashMap<Integer, List<Node>> shortCut = new HashMap<>();

	private static class Node {
		int n, cost;

		Node(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		dp = new int[D + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (end > D)
				continue;
			if (end - start < cost)
				continue;

			if (shortCut.containsKey(start)) {
				shortCut.get(start).add(new Node(end, cost));
			} else {
				List<Node> list = new ArrayList<>();
				list.add(new Node(end, cost));
				shortCut.put(start, list);
			}
		}

		System.out.println(dp(0));
	}

	private static int dp(int n) {
		if (n == D) {
			return 0;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		dp[n] = dp(n + 1) + 1;

		if (shortCut.containsKey(n)) {
			for (Node next : shortCut.get(n)) {
				dp[n] = Math.min(dp[n], dp(next.n) + next.cost);
			}
		}

		return dp[n];
	}
}