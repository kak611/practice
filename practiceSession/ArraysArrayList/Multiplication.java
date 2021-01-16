import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Multiplication {
	public static void main(String[] args) {
		List<Integer> num1 = Arrays.asList(3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2,0,9,7,4,9,4,4,5,9,2);
		List<Integer> num2 = Arrays.asList(2,7,1,8,2,8,1,8,2,8,4,5,9,0,4,5,2,3,5,3,6,0,2,8,7,4,7,1,3,5,2,6,6,2,4,9,7,7,5,7,2,4,7,0,9,3,6,9,9,9,5,9,5,7,4,9,6,6,9,6,7,6,2,7);

		List<Integer> result = multiply(num1, num2);
		System.out.println(num1 + " * " + num2 + ": " + result);
	}

	public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
		//int sign = ((num1.get(0) < 0 && num2.get(0) > 0) || (num1.get(0) > 0 && num2.get(0) < 0)) ? -1 : 1;
		int sign = (num1.get(0) < 0 ^ num2.get(0) < 0) ? -1 : 1; // note: XOR  
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));

		for (int i = num1.size() - 1; i >= 0; --i) {
			for (int j = num2.size() - 1; j >= 0; --j) {
				result.set(i + j + 1, (result.get(i + j + 1) + num1.get(i) * num2.get(j)));
				result.set(i+j, result.get(i+j) + result.get(i+j+1)/10);
				result.set(i+j+1, result.get(i+j+1)%10);
			}
		}

		int firstZeros = 0;
		while(firstZeros < result.size() && result.get(firstZeros) == 0) {
			firstZeros++;
		}

		result = result.subList(firstZeros, result.size());
		if (result.isEmpty()) return Arrays.asList(0);
		result.set(0, result.get(0) * sign);
		return result;
	}

}