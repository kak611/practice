import java.util.*;

class Heap {

	public static final int CAPACITY = 5; //16;
	int[] arr;
	int capacity;
	int size;

	public Heap(int capacity) {
		this.capacity = capacity;
		arr = new int[this.capacity];
		this.size = 0;
	}

	public Heap() {
		this(CAPACITY);
	}

	public Heap(int[] arr) {
		this.capacity = CAPACITY;
		this.arr = arr;
		this.size = arr.length;
		// amortize (load factor 0.75)
		if (arr.length >= 0.75 * this.capacity) {
			amortize(arr);
		}		
		
		buildMinHeap(arr, arr.length - 1);
	}

	public void amortize(int[] input_arr) {
		// within load factor 0.75 (75%)
		while (arr.length >= (0.75 * this.capacity)) {
			this.capacity = this.capacity * 2;
		}

		int[] temp_arr = Arrays.copyOfRange(input_arr, 0, this.capacity);
		// System.out.println("Before amortizing: " + Arrays.toString(input_arr));
		input_arr = temp_arr;
		// System.out.println("After amortizing: " + Arrays.toString(input_arr));
		temp_arr = null;		
	}

	public void buildMinHeap(int[] arr, int i) {
		int parentIndx = (i-1)/2;
		// System.out.println("parentIndx: " + parentIndx);
		parentIndx = (parentIndx < 0) ? 0 : parentIndx;

		for (int j = parentIndx; j >= 0; --j) {
			heapify(arr, arr.length, j);
		}
	}

	public void heapify(int[] arr, int limit, int indx) {
		int leftIndx = 2 * indx + 1;
		int rightIndx = 2 * indx + 2;

		if (leftIndx >= limit || rightIndx >= limit) return;

		int minIndx = (arr[leftIndx] < arr[rightIndx]) ? leftIndx : rightIndx;
		if (arr[minIndx] < arr[indx]) {
			int temp = arr[indx];
			arr[indx] = arr[minIndx];
			arr[minIndx] = temp;

			heapify(arr, limit, minIndx);
		}
	}

	public int extractMin() {
		int min = arr[0];

		// swap with root element
		arr[0] = arr[this.size - 1];
		arr[this.size - 1] = 0;
		this.size--;

		// sift down
		heapify(arr, this.size, 0);
		return min;
	}

	public void insert(int num) {
		if (arr.length >= 0.75 * capacity) amortize(arr);

		arr[size] = num;
		size++;
		siftUp(arr, size - 1);
	}

	public static void siftUp(int arr[], int index) {
		int parentIndx = (index - 1)/2;
		if (parentIndx < 0) return;

		if (arr[parentIndx] > arr[index]) {
			int temp = arr[parentIndx];
			arr[parentIndx] = arr[index];
			arr[index] = temp;

			siftUp(arr, parentIndx);
		}
	}

	public String toString() {
		return Arrays.toString(this.arr);
	}
}