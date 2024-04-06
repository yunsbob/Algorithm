package everyday.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private Map<Character, TrieNode> childNodes = new HashMap<>();
	private boolean isLast;

	public Map<Character, TrieNode> getChildNodes() {
		return this.childNodes;
	}

	public boolean getIsLast() {
		return this.isLast;
	}

	public void setIsLast(boolean isLast) {
		this.isLast = isLast;
	}
}