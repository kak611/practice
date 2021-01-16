import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class IntPermutation {
	static Map<Integer,Integer> map;
	static int count = 0;

	public static void main(String[] args) {
		int[] arr = {2,3,5,7};

		if (arr.length <= 1) return;

		map = new HashMap<>();
		
		for (Integer i : arr) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		generatePerm(arr);
	}

	public static void generatePerm(int[] arr) {
		int[] num_arr = new int[map.size()];
		int[] cnt_arr = new int[map.size()];
		int[] res_arr = new int[arr.length];
		int i=0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			num_arr[i] = (Integer) entry.getKey();
			cnt_arr[i] = (Integer) entry.getValue();
			i++;
		}

		//System.out.println(Arrays.toString(num_arr));
		//System.out.println(Arrays.toString(cnt_arr));

		permutation(num_arr, cnt_arr, res_arr, 0);
		System.out.println("\nTotal permutations: " + count);
	}

	public static void permutation(int[] num_arr, int[] cnt_arr, int[] res_arr, int level) {
		if (res_arr.length == level) {
			System.out.print(Arrays.toString(res_arr) + " ");
			count++;
		}

		for (int i=0; i < num_arr.length; i++) {
			if(cnt_arr[i] > 0) {
				res_arr[level] = num_arr[i];
				cnt_arr[i]--;
				permutation(num_arr, cnt_arr, res_arr, level+1);
				cnt_arr[i]++;
			}
		}
	}
}