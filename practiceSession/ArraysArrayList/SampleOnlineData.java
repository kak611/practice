import java.util.*;

class SampleOnlineData {
	public static void main(String[] args) {
		final int N = 10;
		Integer[] arr = new Integer[N];
		Random random = new Random();
		int max = 30;
		int min = 10;
		for (int i=0; i < arr.length; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		List<Integer> list = Arrays.asList(arr);
		Iterator<Integer> iter = list.iterator();
		int size = 5;
		List<Integer> result = onlineRandomSample(iter, size, list);
		System.out.println("subset of size " + size + ": " + result);



	}

	public static List<Integer> onlineRandomSample(Iterator<Integer> iter, int size, List<Integer> list) {
		List<Integer> result = new ArrayList<>(size);
		int totalNum = 0;
		for (int i=0; i < size && iter.hasNext(); i++) {
			result.add(iter.next());
			totalNum++;
		}

		Random random = new Random();
		while (iter.hasNext()) {
			Integer nextNum = iter.next();
			totalNum++;

			final int randomIndex = random.nextInt(totalNum);
			if (randomIndex < size) {
				list.set(randomIndex, nextNum);
			}
		}
		return result;
	}
}