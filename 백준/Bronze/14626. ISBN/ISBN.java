import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String ISBN = br.readLine();

		int sum = 0;
		int idx = 0;
		for (int i = 0; i < 13; i++) {
			if ('0' <= ISBN.charAt(i) && ISBN.charAt(i) <= '9') {
				if (i % 2 == 1) {
					sum += (ISBN.charAt(i) - '0') * 3;
				} else {
					sum += ISBN.charAt(i) - '0';
				}
			} else {
				idx = i;
			}
		}

		if (idx % 2 == 0) {
			System.out.println(10 - sum % 10);
		} else {
			int num = 0;
			while (true) {
				if ((sum + num * 3) % 10 == 0) {
					System.out.println(num);
					break;
				}
				num++;
			}
		}
	}
}