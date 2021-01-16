import java.util.*;

/*
	https://leetcode.com/discuss/interview-question/366628/Dropbox-or-OA-2019-or-Auto-complete-feature
*/
class TestTrie {
	public static void main(String[] args) {

		List<String> documentTitles = Arrays.asList("ANIMALS", "DOG", "FACTS");
		List<String> documentBodies = Arrays.asList("ANT", "ANTELOPE", "CAMEL", "CAT", "DOG", "FURRY", "FURRY", "LOYAL");
		List<String> queries = Arrays.asList("AN", "DO", "FUR", "ELEPH");

		List<Integer> result = getAutocompleteScores(documentTitles, documentBodies, queries);
		System.out.println("Result: " + result);
	}

	public static List<Integer> getAutocompleteScores(List<String> documentTitles, List<String> documentBodies, List<String> queries) {
		List<Integer> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		// O(max(documentTitles.length, documentBodies.length))
		for (String s : documentTitles) {
			int cnt = map.getOrDefault(s, 0);
			map.put(s, cnt + 10); // document title score is 10
		}

		// O(max(documentTitles.length, documentBodies.length))
		for (String s : documentBodies) {
			int cnt = map.getOrDefault(s, 0);
			map.put(s, cnt + 1); // document body score is 1
		}

		Trie trie = new Trie();
		buildTrie(trie, documentTitles, documentBodies);
		
		// o(s * (n + m)) where, s is number of queries, n is number of documentTitles, m is number of documentBodies
		for (String s : queries) {
			List<String> words = trie.getWords(s);
			int max = 0;
			for (String word : words) {
				max = Math.max(max, map.get(word));
			}
			result.add(max);
		}

		return result;
	}


	public static void buildTrie(Trie trie, List<String> documentTitles, List<String> documentBodies) {
		for (String s : documentTitles) trie.insertWord(s);
		for (String s : documentBodies) trie.insertWord(s);		
	
		/*
		Trie trie = new Trie();
		trie.insertWord("ANIMALS");
		trie.insertWord("ANT");
		trie.insertWord("ANTELOPE");
		trie.insertWord("CAMEL");
		trie.insertWord("CAT");
		trie.insertWord("DOG");
		trie.insertWord("FACTS");
		trie.insertWord("FURRY");
		trie.insertWord("LOYAL");
		trie.insertWord("ANT");


		List<String> result = trie.getWords("CAM");
		System.out.println(result);
		*/		
	}
}