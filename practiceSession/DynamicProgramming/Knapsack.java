import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Knapsack {
	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(65, 20));
		items.add(new Item(35, 8));
		items.add(new Item(245, 60));
		items.add(new Item(195, 55));
		items.add(new Item(65, 40));
		items.add(new Item(150, 70));
		items.add(new Item(275, 85));
		items.add(new Item(155, 25));
		items.add(new Item(120, 30));
		items.add(new Item(320, 65));
		items.add(new Item(75, 75));
		items.add(new Item(40, 10));
		items.add(new Item(200, 95));
		items.add(new Item(100, 50));
		items.add(new Item(220, 40));
		items.add(new Item(99, 10));

		int capacity = 130;

		int value = optimumValue(items, capacity);
		System.out.println("Optimum value: " + value);
	}

	public static int optimumValue(List<Item> items, int capacity) {
		int[][] V = new int[items.size()][capacity + 1];
		for (int[] rows : V) {
			Arrays.fill(rows, -1);
		}

		return optimumValue(items, items.size()-1, capacity, V);
	}

	public static int optimumValue(List<Item> items, int index, int capacity, int[][] V) {
		if (index < 0) return 0; // no clocks left
		if (V[index][capacity] == -1) {
			int withoutItem = optimumValue(items, index-1, capacity, V);
			int withItem = (items.get(index).weight > capacity) ? 0 : items.get(index).value + optimumValue(items, index - 1, capacity - items.get(index).weight, V);
			
			V[index][capacity] = Math.max(withoutItem, withItem);
		}
		
		return V[index][capacity];
	}

	static class Item {
		int value;
		int weight;

		public Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		public String toString() {
			return this.value + ", " + this.weight;
		}
	}
}