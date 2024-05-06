import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		char[] check = {'U', 'C', 'P', 'C'};
		int idx = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == check[idx]) {
				idx++;

				if (idx == 4) {
					System.out.println("I love UCPC");
					System.exit(0);
				}
			}
		}

		System.out.println("I hate UCPC");
	}
}