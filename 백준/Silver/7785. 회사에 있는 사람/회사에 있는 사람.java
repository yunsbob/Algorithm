import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Set<String> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			if (st.nextToken().equals("enter")) {
				hs.add(name);
			} else {
				hs.remove(name);
			}
		}

		hs.stream().sorted(Comparator.reverseOrder()).forEach(name -> sb.append(name).append('\n'));

		System.out.println(sb);
	}
}