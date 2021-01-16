import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

class QueryFrequency {
	public static void main(String[] args) {
		//String str = "If laughter be an aid to health then logic of the strongest Impels us to the cheerful thought That he who laughs lasts longest";		
		List<String> queryList = Arrays.asList("Determination", "Perseverance", "Truth", "Laughter", "Freedom", "Truth", "Practice", "Practice", 
												"Practice", "Determination", "Hope", "Faithful", "Courage", "Love", "Hope", "Perseverance", "Practice", "Practice", "Truth");

		// method 1	(time complexity: O(n + mlogm))
		//List<Word> queries = getFrequentQueries(2, queryList);
		//System.out.println(queries);

		// method 2	
		//List<Word> queries2 = getMostFrequentQueries(2, queryList);
		//System.out.println(queries2);

		// method 3	
		List<Word> queries3 = getMostFrequentUsingRandomization(2, queryList);		
		System.out.println(queries3);
	}


	// method 1: time complexity: o(n + mlogm)
	// 			 space complexity: o(m) where m is distinct strings in hashmap
	public static List<Word> getFrequentQueries(int count, List<String> queryList) {
		List<Word> words = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		for (String str : queryList) {
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			words.add(new Word((String)entry.getKey(), (Integer) entry.getValue()));
		}
		
		Collections.sort(words, Collections.reverseOrder(new Comparator<Word>() {
			public int compare(Word w1, Word w2) {
				return Integer.compare(w1.count, w2.count);
			}
		}));

		return (count >= words.size()) ? words : words.subList(0, count);
	}



	// method 2: using min-heap (time complexity: O(n + mlogk))
	public static List<Word> getMostFrequentQueries(int count, List<String> queryList) {
		Map<String, Integer> map = new HashMap<>();

		// O(n)
		for (String str : queryList) {
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}

		List<Word> queries = new ArrayList<>();

		// O(m) for m distinct strings
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			queries.add(new Word(entry.getKey(), entry.getValue()));
		}

		// create min-heap for to store most frequent queries in heap
		PriorityQueue<Word> pq = new PriorityQueue(count, new Comparator<Word>() {
			public int compare(Word w1, Word w2) {				
				return Integer.compare(w1.count, w2.count);
			}
		});

		// mlogk for k values stored in min-heap
		for (Word w : queries) {
			// logk
			pq.add(w);
			if (pq.size() == count + 1) {
				pq.poll();
			}
		}

		return new ArrayList<Word>(pq);
	}




	// method 3: using divide and conquer & randomization O(n+m)
	public static List<Word> getMostFrequentUsingRandomization(int count, List<String> queryList) {		
		Map<String, Integer> map = new HashMap<>();
		// time complexity: O(n) & space complexity: O(m)
		for (String str : queryList) {
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}

		Word[] queries = new Word[map.size()];
		int i = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			queries[i++] = new Word(entry.getKey(), entry.getValue());
		}

		return partition(queries, 0, queries.length-1, count);
	}

	// O(m)
	private static List<Word> partition(Word[] queries, int start, int end, int count) {
		if (start > end) return null;
		List<Word> temp;
		Random random = new Random();
		int pivotInd = random.nextInt(end - start + 1) + start; // range start..end
		int index = getPivotIndex(queries, start, end, pivotInd);

		if (count == (index + 1)) {
			// print sorted list
			System.out.println("Index: " + index + ", Sorted list: " + Arrays.toString(queries));
			return Arrays.asList(Arrays.copyOfRange(queries, 0, index+1));
		} else if (count > index + 1) {
			//start = index + 1;
			//System.out.println("startIndex: " + index + ", Partially Sorted list: " + Arrays.toString(queries));
			return partition(queries, index+1, end, count);			
		} else {
			//System.out.println("endIndex: " + index + ", Partially Sorted list: " + Arrays.toString(queries));
			//end = index + 1;
			return partition(queries, start, index + 1, count);
		}
	}

	private static int getPivotIndex(Word[] queries, int start, int end, int index) {
		int pivot = queries[index].count;
		swap(queries, index, end);
		int returnIndex = 0;

		for (int i=0; i < end; i++) {
			// sort in descending order as compared to pivot
			if(queries[i].count > pivot) {
				swap(queries, i, returnIndex++);
			}
		}
		swap(queries, returnIndex, end);
		return returnIndex;
	}

	private static void swap(Word[] arr, int i, int j) {
		Word temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}





	static class Word {
		String word;
		int count;

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}

		public String toString() {
			return this.word + ": " + count;
		}

	}
}