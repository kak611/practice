import java.util.List;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;

/*
	Steps:
		1. Construct the structure: 3 pegs + 'n' discs on first peg in descending order bottom-top
		2. Move stack from peg1 to peg2

	Calculating Time Complexity:
		time complexity = (total number of iteration OR total calls) * amount of work done
						Total number of calls to move() are o(2^n - 1) i.e. o(2^n) i.e. (branch ^ depth)
						Amount of work done is O(1) because one print statement
		space complexity: space used by recursion call stack o(n) 

		branch = 2 because two recursive calls inside move()
		depth = n i.e. numOfDiscs because every call moves n-1 disks and at each depth disk is reduced by one till it reaches zero.
		for e.g., for 3 discs, the total number of moves are 2^3-1 = 7.
*/
class TowerOfHanoi {
	static final int NUM_OF_PEGS = 3;
	static List<Deque<Integer>> pegs;
	static int numOfDiscs;

	TowerOfHanoi(int numOfDiscs) {
		this.numOfDiscs = numOfDiscs;
		this.pegs = new ArrayList<>();
		construct();
	}

	public static void construct() {
		// Array of 3 pegs -- each a linked-list
		for (int i=0; i<NUM_OF_PEGS; i++) {
			pegs.add(new LinkedList<Integer>());
			//pegs.set(i, new LinkedList<Integer>());
		}

		// add discs in first peg
		for (int i=numOfDiscs; i > 0; --i) {
			pegs.get(0).addFirst(i);
		}
	}

	// Steps:
	//	1. move (n-1) to p3
	//	2. move nth to p2 
	//	3. move all from p3 to p2
	public static void move(int numOfDiscs, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {
		if (numOfDiscs == 0) return;
		move(numOfDiscs-1, pegs, fromPeg, usePeg, toPeg);
		pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
		System.out.println("Move from " + fromPeg + " peg to " + toPeg + " peg");
		move(numOfDiscs-1, pegs, usePeg, toPeg, fromPeg);
	}

	public static void main(String[] args) {
		TowerOfHanoi toh = new TowerOfHanoi(6);
		toh.move(numOfDiscs, pegs, 0, 1, 2);
	}
}