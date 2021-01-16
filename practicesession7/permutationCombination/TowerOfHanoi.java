import java.util.*;

class TowerOfHanoi {
	/*
	Move disc 1 fromPeg 0 toPeg 1
	Move disc 2 fromPeg 0 toPeg 2
	Move disc 1 fromPeg 1 toPeg 2
	Move disc 3 fromPeg 0 toPeg 1
	Move disc 1 fromPeg 2 toPeg 0
	Move disc 2 fromPeg 2 toPeg 1
	Move disc 1 fromPeg 0 toPeg 1

	    123				    3   12      1   23       	   123
		 |   |   | 		|	|	|		|	|	|		|	|	|
		 ----------		----------		----------		----------

	*/

	static int totalMoves;
	public static void main(String[] args) {
		int n = 3;
		totalMoves = 0;
		List<Deque<Integer>> pegs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			pegs.add(new LinkedList<>());
		}

		int discs = 3;	// 2^3 - 1 = 7
		int discs = 5;	// 2^5 - 1 = 31
		for (int i = discs; i > 0; i--) {
			pegs.get(0).add(i);
		}

		moves(discs, pegs, 0, 1, 2);
		System.out.println("Total moves: " + totalMoves);	
	}

	/* time complexity : T(n - 1) + 1 + T(n - 1) = 2T(n - 1) == 2^n
			OR
		two brances i.e. two recursive calls (toPeg, usePeg) & n depth where n is number of discs
		therefore, 2^n
	*/
	public static void moves(int discs, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {
		if (discs == 0) return;

		moves(discs - 1, pegs, fromPeg, usePeg, toPeg); // T(n - 1)
		pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst()); // O(1)
		System.out.println("Move disc " + discs + " fromPeg " + fromPeg + " toPeg " + toPeg);  // O(1)
		totalMoves++;
		moves(discs - 1, pegs, usePeg, toPeg, fromPeg); // T(n - 1)
	}
}