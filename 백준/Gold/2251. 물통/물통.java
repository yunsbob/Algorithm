import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int A, B, C;
	private static boolean[][][] visited;
	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[A + 1][B + 1][C + 1];

		dfs(0, 0, C);

		Collections.sort(list);
		for (int res : list) {
			sb.append(res).append(' ');
		}

		System.out.println(sb);
	}

	private static void dfs(int a, int b, int c) {
		if (visited[a][b][c]) return;
		visited[a][b][c] = true;
		if (a == 0) list.add(c);

		if (a + c <= A) {
			dfs(a + c, b, 0);
		} else {
			dfs(A, b, c - (A - a));
		}

		if (b + c <= B) {
			dfs(a, b + c, 0);
		} else {
			dfs(a, B, c - (B - b));
		}

		if (b + a <= B) {
			dfs(0, b + a, c);
		} else {
			dfs(a - (B - b), B, c);
		}

		if (c + a <= C) {
			dfs(0, b, c + a);
		} else {
			dfs(a - (C  - c), b, C);
		}

		if (a + b <= A) {
			dfs(a + b, 0, c);
		} else {
			dfs(A, b - (A - a), c);
		}

		if (c + b <= C) {
			dfs(a, 0, c + b);
		} else {
			dfs(a, b - (C - c), c);
		}
	}
}