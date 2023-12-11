package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2342 {
	private static int[] pos;
	private static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		pos = new int[st.countTokens() - 1];
		dp = new int[5][5][pos.length];

		int num = Integer.parseInt(st.nextToken());
		int idx = -1;
		while (num != 0) {
			idx++;
			pos[idx] = num;
			num = Integer.parseInt(st.nextToken());
		}

		System.out.println(DDR(0, 0, idx));
	}

	private static int DDR(int left, int right, int cnt) {
		if (cnt == -1) return 0;
		else if (dp[left][right][cnt] != 0) return dp[left][right][cnt];
		return dp[left][right][cnt] = Math.min(DDR(pos[cnt], right, cnt - 1) + move(left, pos[cnt]), DDR(left, pos[cnt], cnt - 1) + move(right, pos[cnt]));
	}

	private static int move(int now, int next) {
		if (now == 0) return 2;

		int cnt = Math.abs(now - next);

		if (cnt == 0) return 1;
		else if (cnt == 1 || cnt == 3) return 3;
		else return 4;
	}
}
