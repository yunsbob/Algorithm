package everyday.trie;

public class TrieTest {
	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("a");
		trie.insert("abc");
		trie.insert("b");

		System.out.println(trie.search("a"));
		System.out.println(trie.search("ab"));
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("b"));
		System.out.println(trie.search("c"));
	}
}
