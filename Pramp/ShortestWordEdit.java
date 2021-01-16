import java.io.*;
import java.util.*;

class ShortestWordEdit {

	static int shortestWordEditPath(String source, String target, String[] words) {
		Map<String, List<String>> map = new HashMap<>();
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        String s = word.substring(0, i) + "*" + word.substring(i+1);
        // System.out.println(s);
        map.putIfAbsent(s, new ArrayList<>());
        map.get(s).add(word);
      }
    }
    
    // System.out.println(map);
    
    Deque<Obj> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    Set<String> wordSet = new HashSet<>(Arrays.asList(words));
    if (!wordSet.contains(target)) return -1;
    
    queue.add(new Obj(source, 0));
    
    while (!queue.isEmpty()) {
      Obj p = queue.poll();
      String s = p.s;
      int level = p.level;
      // System.out.println("visited" + visited);
      if (visited.contains(s)) continue;
      visited.add(s);
      
      for (int i = 0; i < s.length(); i++) {
        String str = s.substring(0,i) + "*" + s.substring(i+1);
        // System.out.println("=> " + str);
        
        if (!map.containsKey(str)) continue;
        for (String other : map.get(str)) {
          // System.out.println("=> " + str + ": " + other);
          if (other.equals(target)) return level + 1;
          if (!visited.contains(other)) {
            // visited.add(other);
            queue.add(new Obj(other, level + 1));
          }
          // System.out.println(queue);
        }
      }      
    }
    
    return -1;
	}
  
  static class Obj {
    String s;
    int level;
    
    public Obj(String s, int level) {
      this.s = s;
      this.level = level;
    }

    public String toString() {
      return "[" + s + "-" + level + "]";
    }
  }

	public static void main(String[] args) {
	  String[] words = {"but", "put", "big", "pot", "pog", "dog", "lot"};
    //int result = shortestWordEditPath("bit", "dog", words);

    // int result = shortestWordEditPath("aa", "bb", new String[] {"ab", "bb"});
    int result = shortestWordEditPath("bit", "pog", new String[] {"but","put","big","pot","pog","pig","dog","lot"});
    System.out.println("Result: " + result);
	}
}
