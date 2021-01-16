import java.io.*;
import java.util.*;

class SalesPathSolution {
 
  static class Node {
      
    int cost;
    Node[] children;
    Node parent;

    Node(int cost) {
      this.cost = cost;
      children = null;
      parent = null;
    }
  }

  static class SalesPath {
    private Node rootNode;
        
    int getCheapestCost(Node rootNode) {
      if (rootNode == null) return 0;
      return getCheapestCost(rootNode, 0);
    }
    
    int getCheapestCost(Node root, int sum) {
      sum += root.cost;
      if (root.children != null && root.children.length == 0) return sum;

      int min = Integer.MAX_VALUE;
      for (Node node : root.children) {
        min = Math.min(min, getCheapestCost(node, sum));
      }
      
      return min;
    }
  }
    
  /*********************************************
   * Driver program to test above method     *
   *********************************************/

  public static void main(String[] args) {
    String str = "0#3#5#1#4#0#3#2#2#1#1#1#1#0#0#1#10#0#6#2#1#0#5#0";    
    String[] arr = str.split("#");
    Deque<Integer> queue = new LinkedList<>();
    for (String s : arr) {
      queue.add(Integer.parseInt(s));
    }
    System.out.println(queue);
    Node rootNode = getNode(queue);
    SalesPath sp = new SalesPath();
        
    int result = sp.getCheapestCost(rootNode);
    System.out.println("Result: " + result);
  }
  
  public static Node getNode(Deque<Integer> queue) {
    if (queue.isEmpty()) return null;
    
    int val = queue.poll();
    int size = queue.poll();

    Node root = new Node(val);
    root.children = new Node[size];
    if (size == 0) return root;
    
    for (int i = 0; i < root.children.length; i++) {
      root.children[i] = getNode(queue);
    }

    return root;
  }
}