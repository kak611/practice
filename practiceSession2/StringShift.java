import java.util.*;

class StringShift {
	public static void main(String[] args) {
		String str = "joiazl";
		int[][] matrix = {{1,1}, {1, 6}, {0, 2}, {1, 3}, {1, 0}, {0, 3}};
		System.out.println(stringShift(str, matrix));
	}

	public static String stringShift(String s, int[][] shift) {
        if (s == null || s.length() <= 1 || shift.length == 0) return s;
        
        Node dummyNode = new Node('\0');
        Node curr = dummyNode;
        Node prev;
        Node last = null;
        
        // create linkedlist
        for (char c : s.toCharArray()) {
            curr.next = new Node(c);
            curr = curr.next;
        }
        if (curr.next == null) last = curr;
            
        // calculate total moves
        int totalMoves = 0;                
        for (int[] row : shift) {
            int move = 0;
            if (row[1] == s.length()) continue;            
            if (row[0] == 0) {             
                // left shift
                if (row[1] < s.length()) {
                    move = row[1];
                } else {
                    move = row[1] % s.length();
                }                
            } else {
                // right shift
                if (row[1] < s.length()) {
                    move = s.length() - row[1];
                } else {
                    move = s.length() - (row[1] % s.length());
                }
            }
            totalMoves += move;
        }
        
        System.out.println("totalMoves: " + totalMoves);

        curr = dummyNode.next;        
        prev = dummyNode.next;
        display(curr);

        totalMoves %= s.length();
        
        if (totalMoves > 0) {
        	while (--totalMoves > 0) {
	            if (curr.next == null) {
                	curr = dummyNode.next;
            	} else {
	                curr = curr.next;                
            	}
            }
        	// System.out.println("curr: " + curr.c);
        	dummyNode.next = curr.next;
        	curr.next = null;
        	last.next = prev;
        	last = curr;
        }
        
        curr = dummyNode.next;
        StringBuilder strb = new StringBuilder();
        while(curr != null) {
            strb.append(curr.c);
            curr = curr.next;
        }
        return strb.toString();        
    }
    
    public static void display(Node node) {
        while(node != null) {
            System.out.print(node.c + " ");
            node = node.next;
        }
        System.out.println("");
    }
   
     
    static class Node {
        char c;
        Node next;
        
        public Node (char c) {
            this.c = c;
            next = null;
        }
    }
}