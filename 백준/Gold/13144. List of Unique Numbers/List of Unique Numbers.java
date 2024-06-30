import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[100_001];
		int s = 0, e = 0;
		long res = 0;
		while (s < N) {
			while (e < N && cnt[arr[e]] < 1) {
				cnt[arr[e]]++;
				e++;
			}

			res += e - s;
			cnt[arr[s]]--;
			s++;
		}

		System.out.println(res);
	}
}