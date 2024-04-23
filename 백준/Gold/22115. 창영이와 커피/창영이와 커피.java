import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coffee = new int[K + 1];
		Arrays.fill(coffee, 101);
		coffee[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(st.nextToken());

			for (int j = K; j >= c; j--) {
				coffee[j] = Math.min(coffee[j], coffee[j - c] + 1);
			}
		}

		System.out.println(coffee[K] == 101 ? -1 : coffee[K]);
	}
}