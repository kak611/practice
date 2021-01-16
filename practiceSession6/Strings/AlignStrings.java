// sub problem of Text alignment
class AlignStrings {
	public static void main(String[] args) {
		String[] words = {"The", "quick"};
		int numSpaces = 3;

		String result = alignWords(words, numSpaces);
		System.out.println("" + result);
	}

	public static String alignWords(String[] words, int numSpaces) {
		int lo = 0;
		int hi = words.length - 1;
		int wordsLeft = hi - lo + 1;
		System.out.println("wordsLeft: " + wordsLeft);
		StringBuilder strb = new StringBuilder();
		while (lo < hi) {
			strb.append(words[lo++]);
			wordsLeft--;			
			System.out.println("numSpaces: " + numSpaces + ", wordsLeft" + wordsLeft);
			int addSpace = (int)(Math.ceil((double)numSpaces/wordsLeft));
			System.out.println(addSpace);
			for (int i = 0; i < addSpace; i++) {
				strb.append(' ');
			}

			numSpaces -= addSpace;
		}

		strb.append(words[hi]);
		return strb.toString();
	}
}