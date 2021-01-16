import java.util.*;
class TestMyHashMap2 {
	public static void main(String[] args) {
		Random random = new Random();
		MyHashMap2<String, Integer> map = new MyHashMap2();
		map.put("abc", random.nextInt(99) + 1);
		map.put("dsf", random.nextInt(99) + 1);
		map.put("xzc", random.nextInt(99) + 1);
		map.put("saa", random.nextInt(99) + 1);
		map.put("asa", random.nextInt(99) + 1);
		map.put("gfd", random.nextInt(99) + 1);
		map.put("dfd", random.nextInt(99) + 1);
		map.put("132", random.nextInt(99) + 1);
		map.put("456", random.nextInt(99) + 1);
		map.put("hfg", random.nextInt(99) + 1);

		System.out.println(map);		
		System.out.println("gfd: " + map.get("gfd"));
		System.out.println("a: " + map.get("a"));
		System.out.println("remove abc: " + map.remove("abc"));
		System.out.println(map);
		System.out.println("remove 132: " + map.remove("132"));
		System.out.println(map);
	}
}