/*

We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.


badge_records_1 = [
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Paul",     "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Paul",     "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  ["Martha",   "exit"],
]

Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]

Additional test cases:


badge_records_2 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], []

badge_records_3 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: [], ["Paul"]

badge_records_4 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
  ["Martha", "enter"],
  ["Martha", "exit"],
]

Expected output: ["Paul"], ["Paul"]

badge_records_5 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

badge_records_6 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]


n: length of the badge records array

*/

import java.io.*;
import java.util.*;

public class EmployeeBadge {
  static Set<String> miss_entry;
  static Set<String> miss_exit;
  
  public static final String EXIT = "exit";
  public static final String ENTER = "enter";   

  public static List<List<String>> trackEmployees(String[][] entries) {
    List<List<String>> result = new ArrayList<>();    
    Map<String, Integer> map = new HashMap<>();

    miss_entry = new HashSet<>();
    miss_exit = new HashSet<>();
    
    for (String[] entry : entries) {
      int val = map.getOrDefault(entry[0], 0);
      
      if (entry[1].equals(EXIT) && val == 0) {
        miss_entry.add(entry[0]);
      } else if (entry[1].equals(ENTER) && val == 1) {
        miss_exit.add(entry[0]);
      }
      
      int data = (entry[1].equals(EXIT)) ? 0 : 1;
      map.put(entry[0], data);
    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        miss_exit.add(entry.getKey());
      }
    }

    result.add(new ArrayList<>(miss_exit));
    result.add(new ArrayList<>(miss_entry));

    return result;
  }
  
  public static void main(String[] argv) {    
    
    String badgeRecords1[][] = new String[][] {
      {"Martha",   "exit"},
      {"Paul",     "enter"},
      {"Martha",   "enter"},
      {"Martha",   "exit"},
      {"Jennifer", "enter"},
      {"Paul",     "enter"},
      {"Curtis",   "exit"},
      {"Curtis",   "enter"},
      {"Paul",     "exit"},
      {"Martha",   "enter"},
      {"Martha",   "exit"},
      {"Jennifer", "exit"},
      {"Paul",     "enter"},
      {"Paul",     "enter"},
      {"Martha",   "exit"},
    };

    String badgeRecords2[][] = new String[][] {
      {"Paul", "enter"},
      {"Paul", "enter"},
      {"Paul", "exit"},
    };

    String badgeRecords3[][] = new String[][] {
      {"Paul", "enter"},
      {"Paul", "exit"},
      {"Paul", "exit"},
    };

    String badgeRecords4[][] = new String[][] {
      {"Paul", "enter"},
      {"Paul", "exit"},
      {"Paul", "exit"},
      {"Paul", "enter"},
      {"Martha", "enter"},
      {"Martha", "exit"},
    };

    String badgeRecords5[][] = new String[][] {
      {"Paul", "enter"},
      {"Paul", "exit"},
    };

    String badgeRecords6[][] = new String[][] {
      {"Paul", "enter"},
      {"Paul", "enter"},
      {"Paul", "exit"},
      {"Paul", "exit"},
    };
    
    List<List<String>> result1 = trackEmployees(badgeRecords1);    
    System.out.println(result1);

    List<List<String>> result2 = trackEmployees(badgeRecords2);    
    System.out.println(result2);

    List<List<String>> result3 = trackEmployees(badgeRecords3);    
    System.out.println(result3);

    List<List<String>> result4 = trackEmployees(badgeRecords4);    
    System.out.println(result4);

    List<List<String>> result5 = trackEmployees(badgeRecords5);    
    System.out.println(result5);

    List<List<String>> result6 = trackEmployees(badgeRecords6);    
    System.out.println(result6);
  }
  
  
}
