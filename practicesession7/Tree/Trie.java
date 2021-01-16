import java.util.*;

class Trie {

	private Node root;

	public Trie() {
		this.root = new Node();
	}

	// o(n) where n is number of characters
	public void insertWord(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {			
			Node node = curr.children.get(c);

			if (node == null) {
				node = new Node();
				curr.children.put(c, node);
			}
			curr = node;
		}
		curr.isWord = true;
	}

	// o(n) where n is number of characters
	public List<String> getWords(String prefix) {
		List<String> result = new ArrayList<>();
		Node curr = root;
		for (char c : prefix.toCharArray()) {
			curr = curr.children.get(c);
			if (curr == null) return result;
		}
		StringBuilder strb = new StringBuilder(prefix);		
		getWords(curr, strb, result);
		return result;
	}

	public void getWords(Node curr, StringBuilder strb, List<String> result) {
		if (curr == null) return;

		if (curr.isWord) {
			result.add(strb.toString());
		}

		for (char c : curr.children.keySet()) {
			strb.append(c);
			getWords(curr.children.get(c), strb, result);
			strb.deleteCharAt(strb.length() - 1);
		}
	}

	// https://leetcode.com/discuss/interview-question/366628/Dropbox-or-OA-2019-or-Auto-complete-feature
	public List<String> findWordsContainingInputChars(String word) {
		Node curr = root;		
		Set<Character> set = new HashSet();
		for (char c : word.toCharArray()) set.add(c);
		List<String> result = new ArrayList<>();
		
		for (char c : word.toCharArray()) {
			StringBuilder strb = new StringBuilder();
			strb.append(c);
			Node node = curr.children.get(c);
			findWords(node, strb, result, set, word.charAt(0)); // key letter
		}		
		return result;
	}

	public static void findWords(Node curr, StringBuilder strb, List<String> result, Set<Character> set, char key) {
		if (curr == null) return;

		if (curr.isWord) {
			if (strb.indexOf(""+ key) != -1) {
				result.add(strb.toString());
			}
		}

		for (char c : curr.children.keySet()) {
			if (set.contains(c)) {
				strb.append(c);
				findWords(curr.children.get(c), strb, result, set, key);
				strb.deleteCharAt(strb.length() - 1);
			}
		}
	}

	static class Node {
		Map<Character, Node> children;
		boolean isWord;

		public Node() {
			children = new HashMap<>();
			isWord = false;
		}
	}


}