import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class TestIterator {
	public static void main(String[] args) {
		Cars cars = new Cars();

		for (Car car : cars) {
			System.out.println(car);
		}

		// Enhanced for-loop
		for (Car car : cars.getArray()) {
			System.out.println(car);
		}
	}
	
}

class Cars implements Iterable {
	private List<Car> cars;
	private Car[] arr;

	public Cars() {
		// List
		cars = new ArrayList<>();		
		cars.add(new Car(1123123431, "Accent"));
		cars.add(new Car(1544534423, "A4"));
		cars.add(new Car(1642344556, "Q50"));
		cars.add(new Car(1534234563, "C300"));

		// Arrays
		arr = new Car[4];
		arr[0] = new Car(1123123431, "Accent");
		arr[1] = new Car(1544534423, "A4");
		arr[2] = new Car(1642344556, "Q50");
		arr[3] = new Car(1534234563, "C300");
	}

	public Car[] getArray() {
		return this.arr;
	}

	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}