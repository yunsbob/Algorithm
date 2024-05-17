import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int res = 0;
		int[] arr = new int[N];
		int[] cnt = new int[200_001];
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]]++;

			while (cnt[arr[i]] > K) {
				cnt[arr[idx]]--;
				idx++;
			}

			res = Math.max(res, i - idx);
		}

		System.out.println(++res);
	}
}