import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
class LHashMap {
	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		map.put(1,1);
		map.put(2,2);
		map.put(3,3);
		map.put(4,4);
		map.put(5,5);
		map.remove(1);
		map.put(1,1);

		System.out.println(map);
		for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
			break;
		}

	}
}