import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int rCnt = 3, cCnt = 3;
	private static int[][] arr = new int[100][100];
	private static int[] cnt;
	private static PriorityQueue<Num> pq;

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
		if (rCnt >= cCnt) {
			cCnt = 0;

			for (int i = 0; i < rCnt; i++) {
				pq = new PriorityQueue<>();
				cnt = new int[101];
				R(i);
			}
		} else {
			rCnt = 0;

			for (int i = 0; i < cCnt; i++) {
				pq = new PriorityQueue<>();
				cnt = new int[101];
				C(i);
			}
		}
	}

	private static void R(int r) {
		int max = 0;
		for (int j = 0; j < 100; j++) {
			if (arr[r][j] == 0)
				continue;

			cnt[arr[r][j]]++;
			max = Math.max(max, arr[r][j]);
		}

		for (int i = 1; i <= max; i++) {
			if (cnt[i] == 0)
				continue;

			pq.offer(new Num(i, cnt[i]));
		}

		int idx = 0;
		while (!pq.isEmpty()) {
			Num now = pq.poll();

			arr[r][idx++] = now.num;
			arr[r][idx++] = now.cnt;
		}

		for (int j = idx; j < 100; j++) {
			arr[r][j] = 0;
		}

		cCnt = Math.max(cCnt, idx);
	}

	private static void C(int c) {
		int max = 0;
		for (int j = 0; j < 100; j++) {
			if (arr[j][c] == 0)
				continue;

			cnt[arr[j][c]]++;
			max = Math.max(max, arr[j][c]);
		}

		for (int i = 1; i <= max; i++) {
			if (cnt[i] == 0)
				continue;

			pq.offer(new Num(i, cnt[i]));
		}

		int idx = 0;
		while (!pq.isEmpty()) {
			Num now = pq.poll();

			arr[idx++][c] = now.num;
			arr[idx++][c] = now.cnt;
		}

		for (int j = idx; j < 100; j++) {
			arr[j][c] = 0;
		}

		rCnt = Math.max(rCnt, idx);
	}
}