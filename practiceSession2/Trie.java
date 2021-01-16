import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Trie {

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		if (word.length() == 0) return;
		root.addWord(word.toLowerCase());
	}

	public List<String> getWords(String prefix) {
		TrieNode node = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			// System.out.println(">>" + node);
			node = node.getNode(prefix.toLowerCase().charAt(i));
			if (node == null) return new ArrayList<String>();
		}
		return node.getWords();
	}

	



	class TrieNode {
		private TrieNode parent;
		private char character;
		private TrieNode[] children;		
		private boolean isWord;
		private boolean isLeaf;

		public TrieNode() {
			children = new TrieNode[26];
			isWord = false;
			isLeaf = true;
		}

		public TrieNode(char character) {
			this();
			this.character = character;
		}

		public TrieNode getNode(char ch) {
		// System.out.println(ch);
			// System.out.println(Arrays.toString(children));		
			return this.children[ch - 'a'];
		}

		public void addWord(String word) {
			if(word == null || word.length() == 0) return;
			isLeaf = false;
			System.out.println(word);
			char c = word.charAt(0);
			if (this.children[c - 'a'] == null) {
				this.children[c - 'a'] = new TrieNode(c);
				this.children[c - 'a'].parent = this;
			}

			if (word.length() > 1) {
				this.children[c - 'a'].addWord(word.substring(1));
			} else {
				children[c - 'a'].isWord = true;

				System.out.println("is Leaf!");
			}
		}

		public List<String> getWords() {
			List<String> result = new ArrayList<>();

			if (this.isWord) {
				result.add(toString());
			}

			if (!this.isLeaf) {
				for (int i = 0; i < children.length; i++) {
					if (this.children[i] != null) {
						result.addAll(this.children[i].getWords());
					}
				}
			}
			return result;
		}

		public String toString() {
			return (this.parent == null) ? "" : this.parent.toString() + new String(new char[] {character});
		}
	}


}