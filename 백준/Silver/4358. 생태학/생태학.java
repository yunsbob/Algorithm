import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> treeMap = new TreeMap<>();
		int cnt = 0;
		while (true) {
			String tree = br.readLine();

			if (tree == null)
				break;

			treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
			cnt++;
		}

		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			sb.append(entry.getKey()).append(' ').append(String.format("%.4f", (double)entry.getValue() * 100.0 / (double)cnt)).append('\n');
		}

		System.out.println(sb);
	}
}