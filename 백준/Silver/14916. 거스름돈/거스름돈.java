import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if (n == 1 || n == 3) {
			System.out.println(-1);
		} else {
			int res = 0;

			if (n % 5 == 1) {
				res += 3;
				n -= 6;
			} else if (n % 5 == 2) {
				res++;
			} else if (n % 5 == 3) {
				res += 4;
				n -= 8;
			} else if (n % 5 == 4) {
				res += 2;
			}

			System.out.println(res + n / 5);
		}
	}
}