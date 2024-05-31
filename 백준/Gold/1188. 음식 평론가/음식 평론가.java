import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		System.out.println(M - gcd(N, M));
	}

	private static int gcd(int num1, int num2) {
		if (num2 == 0)
			return num1;

		return gcd(num2, num1 % num2);
	}
}