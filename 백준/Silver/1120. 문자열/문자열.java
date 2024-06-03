import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		int res = Integer.MAX_VALUE;
		for (int i = 0; i <= B.length() - A.length(); i++) {
			int cnt = 0;

			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) != B.charAt(j + i)) {
					cnt++;
				}
			}

			res = Math.min(res, cnt);
		}

		System.out.println(res);
	}
}