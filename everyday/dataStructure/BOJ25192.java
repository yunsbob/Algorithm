package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ25192 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int res = 0;
		HashSet<String> hs = new HashSet<>();
		br.readLine();
		for (int i = 1; i < N; i++) {
			String str = br.readLine();
			if (str.equals("ENTER")) {
				hs.clear();
				continue;
			}
			else if (hs.contains(str)) continue;
			res++;
			hs.add(str);
		}

		System.out.println(res);
	}
}
