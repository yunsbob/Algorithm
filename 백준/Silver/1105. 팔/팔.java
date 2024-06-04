import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String L = st.nextToken();
		String R = st.nextToken();
		
		if (L.length() != R.length()) {
			System.out.println(0);
		} else {
			int res = 0;

			for (int i = 0; i < L.length(); i++) {
				char num = L.charAt(i);

				if (num != R.charAt(i)) {
					break;
				} else {
					if (num == '8') {
						res++;
					}
				}
			}

			System.out.println(res);
		}
	}
}