import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static String word1, word2, word3;
	private static boolean flag;
	private static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());

			word1 = st.nextToken();
			word2 = st.nextToken();
			word3 = st.nextToken();
			flag = false;
			check = new boolean[word1.length() + 1][word2.length() + 1];

			dfs(0, 0, 0);

			sb.append("Data set ").append(i).append(": ").append(flag ? "yes" : "no").append('\n');
		}

		System.out.println(sb);
	}

	private static void dfs(int idx1, int idx2, int idx3) {
		if (check[idx1][idx2])
			return;

		if (idx3 == word3.length()) {
			flag = true;
			return;
		}

		check[idx1][idx2] = true;

		if (idx1 < word1.length() && word3.charAt(idx3) == word1.charAt(idx1))
			dfs(idx1 + 1, idx2, idx3 + 1);

		if (flag)
			return;

		if (idx2 < word2.length() && word3.charAt(idx3) == word2.charAt(idx2))
			dfs(idx1, idx2 + 1, idx3 + 1);
	}
}