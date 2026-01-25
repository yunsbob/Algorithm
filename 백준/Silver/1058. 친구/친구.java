import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] floyd = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();

			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}

				if (in.charAt(j) == 'Y') {
				 	floyd[i][j] = 1;
				} else {
					floyd[i][j] = 51;
				}
			}
		}

		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				for (int k = 0; k < N; k++){
					if (j == k) {
						continue;
					}

					floyd[j][k] = Math.min(floyd[j][k], floyd[j][i] + floyd[i][k]);
				}
			}
		}


		int res = 0;

		for (int i = 0; i < N ; i++) {
			int cnt = 0;

			for (int j = 0; j < N ; j++) {
				if (floyd[i][j] == 2 || floyd[i][j] == 1){
					cnt++;
				}
			}

			res = Math.max(res, cnt);
		}

		System.out.println(res);
	}
}