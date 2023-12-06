package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1092 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(crane, Collections.reverseOrder());

		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box, Collections.reverseOrder());

		int res = 0;
		if (box.get(0) > crane.get(0)) {
			res = -1;
		} else {
			while (!box.isEmpty()) {
				int idx = 0;
				A: for (int i = 0; i < N; i++) {
					if (idx == box.size()) break;
					while (crane.get(i) < box.get(idx)) {
						idx++;
						if (idx == box.size()) break A;
					}
					box.remove(idx);
				}
				res++;
			}
		}

		System.out.println(res);
	}
}
