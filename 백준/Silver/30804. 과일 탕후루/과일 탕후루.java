import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] check = new int[10];
		check[arr[0]] = 1;
		int s = 0, e = 1, cnt = 1, kind = 1, res = 1;
		while (e < N) {
			int now = arr[e];
			check[now]++;
			cnt++;

			if (check[now] == 1) {
				kind++;
				while (kind > 2) {
					now = arr[s];
					check[now]--;
					cnt--;
					s++;
					if (check[now] == 0) {
						kind--;
					}
				}
			}

			res = Math.max(res, cnt);
			e++;
		}

		System.out.println(res);
	}
}