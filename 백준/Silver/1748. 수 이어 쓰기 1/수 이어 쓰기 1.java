import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int res = 0, cnt = 1, next = 10;
		for (int i = 1; i <= N; i++) {
			if (i == next) {
				cnt++;
				next *= 10;
			}
			res += cnt;
		}

		System.out.println(res);
	}
}