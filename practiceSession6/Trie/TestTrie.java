class TestTrie {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("orange");
		trie.insert("orangepineapple");
		trie.insert("orangepulp");
		trie.insert("apple");
		trie.insert("applemango");
		trie.insert("banana");

		System.out.println(trie);
		
		System.out.println(trie.search("guava"));
		System.out.println("Search applemango: " + trie.search("applemango"));
		System.out.println("Search apple: " + trie.search("apple"));
		System.out.println("Delete apple... ");
		trie.delete("apple");
		System.out.println("Search apple: " + trie.search("apple"));
		System.out.println("Search applemango: " + trie.search("applemango"));
		System.out.println(trie);
		System.out.println("Delete applemango... ");
		trie.delete("applemango");
		System.out.println("Delete orangepineapple... ");
		trie.delete("orangepineapple");
		System.out.println(trie);
	}
}