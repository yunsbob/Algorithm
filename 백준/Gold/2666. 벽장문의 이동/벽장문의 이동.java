import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int w;
	private static int[] closet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		br.readLine();
		st = new StringTokenizer(br.readLine());
		int open1 = Integer.parseInt(st.nextToken());
		int open2 = Integer.parseInt(st.nextToken());

		w = Integer.parseInt(br.readLine());
		closet = new int[w];
		for (int i = 0; i < w; i++) {
			closet[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(dfs(open1, open2, 0));
	}

	private static int dfs(int open1, int open2, int now) {
		if (now == w)
			return 0;

		return Math.min(Math.abs(open1 - closet[now]) + dfs(closet[now], open2, now + 1),
			Math.abs(open2 - closet[now]) + dfs(open1, closet[now], now + 1));
	}
}