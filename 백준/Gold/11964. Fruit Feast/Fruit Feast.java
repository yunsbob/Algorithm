import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int T, A, B, res = 0;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		visited = new boolean[T + 1];

		eat(0, false);

		System.out.println(res);
	}

	private static void eat(int fullness, boolean water) {
		if (visited[fullness]) {
			return;
		}

		visited[fullness] = true;
		res = Math.max(res, fullness);

		if (fullness + A <= T) {
			eat(fullness + A, water);
		}
		if (fullness + B <= T) {
			eat(fullness + B, water);
		}
		if (!water) {
			eat(fullness / 2, true);
		}
	}
}