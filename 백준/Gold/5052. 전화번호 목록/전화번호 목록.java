import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	private static class TrieNode {
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		private boolean isLast;

		void insert(String word) {
			TrieNode rootNode = this;
			for (int i = 0; i < word.length(); i++) {
				rootNode = rootNode.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}

			rootNode.isLast = true;
		}

		boolean search(String word) {
			TrieNode rootNode = this;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode node = rootNode.childNodes.get(c);

				if (node == null)
					return false;

				rootNode = node;
			}

			if (rootNode.isLast) {
				if (rootNode.childNodes.isEmpty()) {
					return false;
				}
			}

			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			TrieNode trieNode = new TrieNode();
			boolean consistency = true;
			List<String> list = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				String str = br.readLine();
				trieNode.insert(str);
				list.add(str);
			}

			for (String str : list) {
				if (trieNode.search(str)) {
					consistency = false;
					break;
				}
			}

			if (consistency) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}

		System.out.println(sb);
	}
}