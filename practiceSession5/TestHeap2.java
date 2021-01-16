import java.util.*;

class TestHeap2 {
	public static void main(String[] args) {
		int min = 100;
		int max = 1000;
		Random random = new Random();
		Heap heap = new Heap();
		System.out.println(heap);

		heap.insert(random.nextInt(max - min) + 1);
		System.out.println("Insert: " + heap);
		heap.insert(random.nextInt(max - min) + 1);
		System.out.println("Insert: " + heap);
		heap.insert(random.nextInt(max - min) + 1);
		System.out.println("Insert: " + heap);
		heap.insert(random.nextInt(max - min) + 1);
		System.out.println("Insert: " + heap);
		heap.insert(random.nextInt(max - min) + 1);
		System.out.println("Insert: " + heap);

		System.out.print("HeapSort: ");
		while(heap.size > 0) {
			System.out.print(heap.extractMin() + " ");
		}
		System.out.println();
	}
}