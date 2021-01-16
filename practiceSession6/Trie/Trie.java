import java.util.*;

class Trie {
	static TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public static void insert(String s) {
		TrieNode curr = root;

		for (int i = 0; i < s.length(); i++) {
			TrieNode node = curr.children.get(s.charAt(i));
			if (node == null) {
				node = new TrieNode();
				curr.children.put(s.charAt(i), node);
			}
			curr = node;
		}

		curr.endOfWord = true;
	}

	public static boolean search(String s) {
		TrieNode curr = root;

		for (int i = 0; i < s.length(); i++) {
			TrieNode node = curr.children.get(s.charAt(i));
			if (node == null) {
				return false;
			} else {
				curr = node;
			}
		}

		return curr.endOfWord;
	}

	public static boolean delete(String s) {
		return delete(s, 0, root);
	}

	public static boolean delete(String s, int index, TrieNode curr) {
		if (index == s.length()) {			
			if (!curr.endOfWord) return false;
			curr.endOfWord = false;			
			return (curr.children.size() == 0);
		}

		TrieNode node = curr.children.get(s.charAt(index));
		if (node == null) return false;		
		boolean shouldDelete = delete(s, index + 1, node);

		if (shouldDelete) {
			// System.out.println("deleting : " + s.charAt(index) + " from  map=>" +  curr);
			curr.children.remove(s.charAt(index));
			return (curr.children.size() == 0);
		}

		return false;
	}

	public String toString() {
		return "\n" + root.children.toString();
	}



	static class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

		public String toString() {
			return children.toString() + "-" + endOfWord;
		}
	}
}