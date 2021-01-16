import java.util.*;

/*
	https://leetcode.com/discuss/interview-question/354523/Dropbox-or-OA-2019-or-Spelling-Bee
*/

class SpellingBee {
	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("APPLE", "PLEAS", "PLEASE");
		List<String> puzzles = Arrays.asList("AELWXYZ", "AELPXYZ", "AELPSXY", "SAELPXY", "XAELPSY");

		List<Integer> result = validWordsInPuzzle(wordList, puzzles);
		System.out.println("Result: " + result);
	}

	public static List<Integer> validWordsInPuzzle(List<String> wordList, List<String> puzzles) {
		// build tree
		Trie trie = new Trie();
		for (String word : wordList) {
			trie.insertWord(word);
		}

		List<Integer> result = new ArrayList<>();
		for (String puzzle : puzzles) {
			List<String> res = trie.findWordsContainingInputChars(puzzle);
			System.out.println("words for '" + puzzle + "' : " + res);
			result.add(res.size());
		}

		return result;
	}

}