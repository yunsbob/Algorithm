import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> treeMap = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			String extension = st.nextToken();
			treeMap.put(extension, treeMap.getOrDefault(extension, 0) + 1);
		}

		for (Map.Entry<String, Integer> extension : treeMap.entrySet()) {
			sb.append(extension.getKey()).append(' ').append(extension.getValue()).append('\n');
		}

		System.out.println(sb);
	}
}