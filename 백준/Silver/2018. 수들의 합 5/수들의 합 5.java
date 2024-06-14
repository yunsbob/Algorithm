import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int s = 1, res = 0, sum = 0;

		for (int i = 1; i <= N; i++) {
			sum += i;

			while (N < sum) {
				sum -= s;
				s++;
			}
			
			if (N == sum)
				res++;
		}

		System.out.println(res);
	}
}