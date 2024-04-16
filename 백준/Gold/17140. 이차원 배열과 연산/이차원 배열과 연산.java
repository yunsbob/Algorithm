import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int rCnt = 3, cCnt = 3;
	private static int[][] arr = new int[100][100];
	private static PriorityQueue<Num> pq = new PriorityQueue<>();
	private static Map<Integer, Integer> hm = new HashMap<>();

	private static class Num implements Comparable<Num> {
		int num, cnt;

		public Num(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Num o) {
			if (this.cnt == o.cnt) {
				return this.num - o.num;
			} else {
				return this.cnt - o.cnt;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int t = 0;
		while (t <= 100) {
			if (arr[r - 1][c - 1] == k)
				break;

			sort();
			t++;
		}

		System.out.println(t == 101 ? -1 : t);
	}

	private static void sort() {
		if (rCnt >= cCnt)
			R();
		else
			C();
	}

	private static void R() {
		int maxC = 0;

		for (int i = 0; i < rCnt; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 0)
					continue;

				hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0) + 1);
			}

			hm.forEach((num, cnt) -> pq.offer(new Num(num, cnt)));

			int idx = 0;
			while (!pq.isEmpty()) {
				Num now = pq.poll();

				arr[i][idx++] = now.num;
				arr[i][idx++] = now.cnt;

				if (idx == 100) {
					pq.clear();
					break;
				}
			}

			for (int j = idx; j < 100; j++) {
				arr[i][j] = 0;
			}

			maxC = Math.max(maxC, idx);
			hm.clear();
		}

		cCnt = maxC;
	}

	private static void C() {
		int maxR = 0;

		for (int i = 0; i < cCnt; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[j][i] == 0)
					continue;

				hm.put(arr[j][i], hm.getOrDefault(arr[j][i], 0) + 1);
			}

			hm.forEach((num, cnt) -> pq.offer(new Num(num, cnt)));

			int idx = 0;
			while (!pq.isEmpty()) {
				Num now = pq.poll();

				arr[idx++][i] = now.num;
				arr[idx++][i] = now.cnt;

				if (idx == 100) {
					pq.clear();
					break;
				}
			}

			for (int j = idx; j < 100; j++) {
				arr[j][i] = 0;
			}

			maxR = Math.max(maxR, idx);
			hm.clear();
		}

		rCnt = maxR;
	}
}