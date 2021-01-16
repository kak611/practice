class TrieTest {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("thousandone");
		trie.addWord("thousandtwo");
		trie.addWord("thousands");
		trie.addWord("three");

		System.out.println(trie.getWords("thousando"));
	}
}