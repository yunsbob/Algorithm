import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] arr = new long[31];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i <= 30; i++) {
			for (int j = 0; j < i; j++) {
				arr[i] += arr[j] * arr[i - 1 - j];
			}
		}

		int N = Integer.parseInt(br.readLine());
		while (N != 0) {
			sb.append(arr[N]).append('\n');
			N = Integer.parseInt(br.readLine());
		}

		System.out.println(sb);
	}
}