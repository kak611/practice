/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID. 

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["215", "user_6", "resource_4"],
    ["200", "user_6", "resource_5"],    
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_2"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["898", "user_1", "resource_3"],
    ["1197", "user_1", "resource_3"],
    ["1198", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, 
together with how many accesses it saw.

Expected Output:
most_requested_resource(logs) # => ('resource_3', 3)
Reason: resource_3 is accessed at 53760, 54001, and 54060

most_requested_resource(logs2) # => ('resource_3', 4)
Reason: resource_3 is accessed at 1197, 1198, 1199, and 1200

Complexity analysis variables:

n: number of logs in the input

*/

/*
  HashMap: String : TreeSet
*/
import java.io.*;
import java.util.*;

public class Resources {
  public static void main(String[] argv) {
    String[][] logs = new String[][] {
        { "58523", "user_1", "resource_1" },
        { "62314", "user_2", "resource_2" },
        { "54001", "user_1", "resource_3" },
        { "200", "user_6", "resource_5" },
        { "215", "user_6", "resource_4" },
        { "54060", "user_2", "resource_3" },
        { "53760", "user_3", "resource_3" },
        { "58522", "user_22", "resource_1" },
        { "53651", "user_5", "resource_3" },
        { "2", "user_6", "resource_1" },
        { "100", "user_6", "resource_6" },
        { "400", "user_7", "resource_2" },
        { "100", "user_8", "resource_2" },
        {"54359", "user_1", "resource_3"},
    };

    String[][] logs2 = new String[][] {
        {"300", "user_1", "resource_3"},
        {"599", "user_1", "resource_3"},
        {"898", "user_1", "resource_3"},
        {"1197", "user_1", "resource_3"},
        {"1198", "user_1", "resource_3"},
        {"1199", "user_1", "resource_3"},
        {"1200", "user_1", "resource_3"}
    };
    /*
    Map<String, ArrayList<Integer>> map1 = getResult(logs);
    System.out.println("Result1: " + map1);
    
    Map<String, ArrayList<Integer>> map2 = getResult(logs2);
    System.out.println("Result2: " + map2);*/
    
    Result r1 = getResult2(logs);
    System.out.println("Result1: " + r1);

    Result r2 = getResult2(logs2);
    System.out.println("Result2: " + r2);
  }
  

  /*
    Second problem:
      Find the resource with the highest number of accesses in any 5 minute window, 
      together with how many accesses it saw.
  */
  public static final int WINDOW_SIZE = 5 * 60;
  public static Result getResult2(String[][] logs) {
    Map<String, TreeSet<Integer>> map = new HashMap();

    int k = 1;
    PriorityQueue<Result> pq = new PriorityQueue<>(k, new Comparator<Result>() {
      public int compare(Result r1, Result r2) {
        return Integer.compare(r1.count, r2.count);
      }
    });

    for (String[] log : logs) {
      map.putIfAbsent(log[2], new TreeSet<>());
      map.get(log[2]).add(Integer.parseInt(log[0]));    
    }    

    for (Map.Entry<String, TreeSet<Integer>> entry : map.entrySet()) {
      Deque<Integer> queue = new LinkedList<>();      
      TreeSet<Integer> set = entry.getValue();
      if (set.size() == 0) {
        pq.add(new Result(entry.getKey(), 0));
        continue;
      }
      // System.out.println(entry.getKey() + ": " + set);
      int max = 0;
      while (set.size() > 0) {
        if (queue.isEmpty() || (queue.peekFirst() + WINDOW_SIZE) >= set.first()) {
          queue.add((Integer)set.pollFirst());
        } else {
          max = Math.max(max, queue.size());
          queue.pollFirst();
        }
      }
      max = Math.max(max, queue.size());
      pq.add(new Result(entry.getKey(), max));
      if (pq.size() > k) pq.poll();
    }
    
    return pq.poll();
  }
  

  static class Result {
    String res;
    int count;
    
    public Result(String res, int count) {
      this.res = res;
      this.count = count;
    }

    public String toString() {
      return this.res + ", " + this.count;
    }
  }
  
  
  
  /*
    First problem:
      Find the earliest and latest timestamp for each user
  */
  
  public static Map<String, ArrayList<Integer>> getResult(String[][] logs) {
    Map<String, TreeSet<Integer>> map = new HashMap();
    
    for (String[] log : logs) {
      map.putIfAbsent(log[1], new TreeSet<>());
      map.get(log[1]).add(Integer.parseInt(log[0]));
    }
       
    Map<String, ArrayList<Integer>> result = new HashMap<>();
    
    for (Map.Entry<String, TreeSet<Integer>> entry : map.entrySet()) {
      result.putIfAbsent(entry.getKey(), new ArrayList<>());
      int first = entry.getValue().first();
      int last = entry.getValue().last();
      result.get(entry.getKey()).add(first);
      result.get(entry.getKey()).add(last);
    }
    
    return result;
  }
}
