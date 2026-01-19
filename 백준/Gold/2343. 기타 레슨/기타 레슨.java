import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] lectures;
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int sum = 0, l = 0;

		lectures = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			l = Math.max(l, lectures[i]);
			sum += lectures[i];
		}

		System.out.println(binarySearch(l, sum));
	}

	public static long binarySearch(long left, long right) {
		if (left <= right) {
			long sum = 0;
			long mid = (left + right) / 2;
			int cnt = 1;

			for(int i = 0; i < N; i++){
				sum += lectures[i];

				if (sum > mid) {
					sum = lectures[i];
					cnt++;
				}
			}

			if(cnt <= M) {
				return binarySearch(left, mid - 1);
			}
			else {
				return binarySearch(mid + 1, right);
			}
		}

		return left;
	}
}