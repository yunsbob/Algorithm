import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int recursionCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		fib(N);

		int dpCnt = 0;
		for (int i = 3; i <= N; i++) {
			dpCnt++;
		}

		System.out.println(recursionCnt + " " + dpCnt);
	}

	private static void fib(int n) {
		if (n == 1 || n == 2) {
			recursionCnt++;
		}
		else {
			fib(n - 1);
			fib(n - 2);
		}
	}
}