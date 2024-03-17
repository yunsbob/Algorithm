import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		int[][] alphaCnt = new int[2][26];
		for (int i = 0; i < A.length(); i++) {
			alphaCnt[0][A.charAt(i) - 'A']++;
			alphaCnt[1][B.charAt(i) - 'A']++;
		}

		for (int i = 0; i < 26; i++) {
			if (alphaCnt[0][i] != alphaCnt[1][i]) {
				System.out.println(-1);
				System.exit(0);
			}
		}

		int cnt = 0, aIdx = A.length(), bIdx = aIdx - 1;
		while (--aIdx >= 0) {
			if (B.charAt(bIdx) != A.charAt(aIdx)) {
				cnt++;
			} else {
				bIdx--;
			}
		}

		System.out.println(cnt);
	}
}