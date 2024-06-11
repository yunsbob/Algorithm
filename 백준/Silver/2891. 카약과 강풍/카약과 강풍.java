import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			arr[Integer.parseInt(st.nextToken())]--;
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 1) {
				if (arr[i - 1] == -1) {
					arr[i - 1]++;
					arr[i]--;
				} else if (arr[i + 1] == -1) {
					arr[i + 1]++;
					arr[i]--;
				} else {
					res++;
				}
			}
		}

		System.out.println(res);
	}
}