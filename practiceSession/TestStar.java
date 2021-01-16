import java.util.*;

class TestStar {
	public static void main(String[] args) {
		ArrayList<Star> arrList = new ArrayList<Star>();
		arrList.add(new Star(1.1, 2.2, 3.3));
		arrList.add(new Star(2.1, 8.2, 4.4));
		arrList.add(new Star(1.2, 2.3, 4.3));
		arrList.add(new Star(3.3, 2.2, 3.8));
		arrList.add(new Star(4.2, 2.1, 6.3));
		arrList.add(new Star(5.6, 1.2, 4.8));
		arrList.add(new Star(7.8, 9.2, 5.0));
		arrList.add(new Star(1.8, 6.2, 6.4));

		System.out.println(arrList);
		Collections.sort(arrList);
		System.out.println("Sorted: " + arrList);
		Collections.sort(arrList, Collections.reverseOrder());
		System.out.println("Reverse Sorted: " + arrList);
		List.sort(arrList);	// throws error
	}
}
class Star implements Comparable<Star> {
	private double x, y, z;

	public Star(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double distance() {
		return Math.sqrt(x*x + y*y + z*z);
	}

	@Override
	public int compareTo(Star star2) {
		return Double.compare(this.distance(), star2.distance());
	}

	@Override
	public String toString() {
		return "" + distance();
	}
}

