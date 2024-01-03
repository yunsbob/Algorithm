package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1062 {
	private static boolean[] check = new boolean[26];
	private static String[] words;
	private static int res = 0;
	private static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		check['a' - 'a'] = check['c' - 'a'] = check['i' - 'a'] = check['n' - 'a'] = check['t' - 'a'] = true;

		if (K >= 5) {
			DFS(1, 5);
		}
		else if (K == 26) {
			res = N;
		}

		System.out.println(res);
	}

	private static void DFS(int now, int cnt) {
		if (cnt == K) {
			int wordCnt = read();
			res = res < wordCnt ? wordCnt : res;
		}
		else {
			for (int i = now; i < 26; i++) {
				if (check[i]) continue;
				check[i] = true;
				DFS(i + 1, cnt + 1);
				check[i] = false;
			}
		}
	}

	private static int read() {
		int wordCnt = 0;
		A: for (int i = 0; i < N; i++) {
			for (int j = 4; j < words[i].length() - 4; j++) {
				if (!check[words[i].charAt(j) - 'a'])
					continue A;
			}
			wordCnt++;
		}
		return wordCnt;
	}
}
