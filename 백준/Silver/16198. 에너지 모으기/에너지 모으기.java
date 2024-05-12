import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, res = 0;
	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		dfs(0, 0);

		System.out.println(res);
	}

	private static void dfs(int cnt, int sum) {
		if (cnt == N - 2) {
			res = Math.max(res, sum);
		} else {
			for (int i = 1; i < N - cnt - 1; i++) {
				int n = list.get(i);
				list.remove(i);
				dfs(cnt + 1, sum + list.get(i - 1) * list.get(i));
				list.add(i, n);
			}
		}
	}
}