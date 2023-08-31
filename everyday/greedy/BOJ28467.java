package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ28467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long N = Long.parseLong(br.readLine());
		List<Long> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}

		long res = 0;
		while (list.size() != 1) {
			int idx = 0;
			for (int i = 1; i < list.size() - 1; i++) {
				if (Math.max(list.get(idx), list.get(idx + 1)) > Math.max(list.get(i), list.get(i + 1))) {
					idx = i;
				}
			}

			res += list.get(idx) + list.get(idx + 1);
			if (list.get(idx) > list.get(idx + 1))
				list.remove(idx + 1);
			else
				list.remove(idx);
		}

		System.out.println(res);
	}
}
