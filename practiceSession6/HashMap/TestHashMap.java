class TestHashMap {
	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		System.out.println(map.get("one"));
		map.put("one", 3245);
		System.out.println(map.get("one"));
		map.put("two", 657);
		map.put(null, 1);
		System.out.println(map.get(null));
		map.put("neo", 22);
		map.put("eno", 44);
		map.put("fdg", 46574);
		map.put("hgj", 464);
		map.put("sdf", 4465);
		map.put("try", 4434);
		System.out.println("Hash of hgj: " + map.getHash("hgj"));
		System.out.println("bucketIndex of hgj: " + map.getHash("hgj") % map.capacity());
		System.out.println("Hash of try: " + map.getHash("try"));
		System.out.println("bucketIndex of try: " + map.getHash("try") % map.capacity());

		System.out.println(map.get("neo"));

		System.out.println("Removing: " + map.remove("one"));
		System.out.println(map.get("one"));
		System.out.println(map);
		map.put("neo", 32455423);
		System.out.println(map);
		map.remove("try");
		System.out.println(map);
		map.put("try", 4434);
		map.remove("hgj");
		System.out.println(map);
		map.put("hgj", 3248923);
		System.out.println(map);
	}
}