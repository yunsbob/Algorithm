import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] pos = new int[26][2];
		String str = br.readLine();

		int idx = 0;
		while (idx < 52) {
			int now = str.charAt(idx) - 'A';
			if (pos[now][0] == 0) pos[now][0] = ++idx;
			else pos[now][1] = ++idx;
		}

		int res = 0;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (pos[i][0] < pos[j][0] && pos[j][0] < pos[i][1] && pos[i][1] < pos[j][1]) res++;
			}
		}

		System.out.println(res);
	}
}