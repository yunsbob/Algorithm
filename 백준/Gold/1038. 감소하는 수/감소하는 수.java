import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private static List<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N <= 10) {
			System.out.println(N);
		} else {
			for (int i = 0; i < 10; i++) {
				dfs(i, 1);
			}

			if (list.size() <= N) {
				System.out.println(-1);
			} else {
				Collections.sort(list);
				System.out.println(list.get(N));
			}
		}
	}

	private static void dfs(long num, int idx) {
		if (idx > 10)
			return;

		list.add(num);

		for (int i = 0; i < num % 10; i++) {
			dfs(num * 10 + i, idx + 1);
		}
	}
}