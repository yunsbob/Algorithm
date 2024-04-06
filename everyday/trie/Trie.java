package everyday.trie;

public class Trie {
	private TrieNode rootNode;

	Trie() {
		this.rootNode = new TrieNode();
	}

	void insert(String word) {
		TrieNode rootNode = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			rootNode = rootNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}

		rootNode.setIsLast(true);
	}

	boolean search(String word) {
		TrieNode rootNode = this.rootNode;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = rootNode.getChildNodes().get(c);

			if (node == null)
				return false;

			rootNode = node;
		}

		return rootNode.getIsLast();
	}
}
