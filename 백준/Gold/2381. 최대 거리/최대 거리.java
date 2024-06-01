import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int sumMax = Integer.MIN_VALUE, sumMin = Integer.MAX_VALUE, subMax = Integer.MIN_VALUE, subMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sumMax = Math.max(sumMax, a + b);
			sumMin = Math.min(sumMin, a + b);
			subMax = Math.max(subMax, a - b);
			subMin = Math.min(subMin, a - b);
		}

		System.out.println(Math.max(sumMax - sumMin, subMax - subMin));
	}
}