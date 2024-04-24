import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int flag = 0;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				flag = 1;
				break;
			}

			if (flag == 2)
				continue;

			if (str.charAt(i) != str.charAt(i + 1))
				flag = 2;
		}

		switch (flag) {
			case 0:
				System.out.println(-1);
				break;
			case 1:
				System.out.println(str.length());
				break;
			case 2:
				System.out.println(str.length() - 1);
		}
	}
}