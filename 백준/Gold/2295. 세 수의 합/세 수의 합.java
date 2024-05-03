import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] U = new int[N];
		for (int i = 0; i < N; i++) {
			U[i] = Integer.parseInt(br.readLine());
		}

		Set<Integer> hs = new HashSet<>();
		for (int x = 0; x < N - 1; x++) {
			for (int y = x; y < N; y++) {
				hs.add(U[x] + U[y]);
			}
		}

		int res = 0;
		for (int z = 0; z < N; z++) {
			for (int k = 0; k < N; k++) {
				if (z == k) continue;

				if (hs.contains(U[k] - U[z])) {
					res = Math.max(res, U[k]);
				}
			}
		}

		System.out.println(res);
	}
}