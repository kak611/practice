import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Test {
	public static void main(String[] args) {
		//int[] arr = new int[5];
		//arr[5] = 2;		
		//System.out.println(Arrays.toString(arr)); // ArrayOutOfBoundException

		// List<Integer> list1 = Arrays.asList(1,2,3,4);		
		// System.out.println(list1);
		// List<Integer> list2 = Arrays.asList(new Integer[] {1,2,3,4});
		// System.out.println(list2);
		// List<Integer> list3 = Arrays.asList(new Integer[4]);
		// System.out.println(list3);
		// //List<Integer> list4 = Arrays.asList(new int[] {1,2,4});
		// System.out.println(list4);


		// int b = 5;
		// System.out.println(++b);
		// System.out.println(b++);
		// System.out.println(++b);
		

		//	======  ++i  ======
		int i;
		System.out.println("======  ++i  ======");
		System.out.println("i = " + (i = 5));
		System.out.println("while(++i < 8) ==> increment & compare then go inside");
		while(++i < 8) {			
			System.out.println(i);
		}
		System.out.println("\n");

		System.out.println("i = " + (i = 5));
		System.out.println("do..while(++i < 8) ==> use current & go inside then increment & compare & go inside");
		do {
			System.out.println(i);
		} while(++i < 8);
		System.out.println("\n");

		System.out.println("for (i = 5; i < 8; ++i) ==> compare then use and then increment");
		for (i = 5; i < 8; ++i) {
			System.out.println(i);
		}
		System.out.println("\n");

		System.out.println("for (i = 5; i < 8; ) ==> compare then increment & use");
		for (i = 5; i < 8;) {
			System.out.println(++i);
		}
		System.out.println("\n");

		System.out.println("for (i = 5; i < 8; ++i) ==> compare then increment & use & again increment");
		for (i = 5; i < 8; ++i) {
			System.out.println(++i);
		}
		System.out.println("\n");
		

		//	======  i++  ======
		System.out.println("======  i++  ======");
		System.out.println("i = " + (i = 5));
		System.out.println("while(i++ < 8) ==> compare & increment then go inside");
		while(i++ < 8) {			
			System.out.println(i);
		}
		System.out.println("\n");

		System.out.println("i = " + (i = 5));
		System.out.println("do..while(i++ < 8) ==> use current & go inside then compare & increment & go inside");
		do {
			System.out.println(i);
		} while(i++ < 8);
		System.out.println("\n");

		System.out.println("for (i = 5; i < 8; i++) ==> compare then use and then increment");
		for (i = 5; i < 8; i++) {
			System.out.println(i);
		
		}System.out.println("\n");

		System.out.println("for (i = 5; i < 8;) ==> compare then use and then increment");
		for (i = 5; i < 8; ) {
			System.out.println(i++);
		}
		System.out.println("\n");

		System.out.println("for (i = 5; i < 8; i++) ==> compare then 'use & increment' and then increment");
		for (i = 5; i < 8; i++) {
			System.out.println(i++);
		}
		System.out.println("\n");

		int[] a = {1,2,3,4,5};
		int m=0;
		while(m++ < a.length-1) {
			System.out.println("a[m]" + a[m]);
		}


		float c = 1.7014117E38f; // Float.MAX_VALUE/2;
		double d = 1.7014117E38d; // Float.MAX_VALUE/2;
		System.out.println(c);
		System.out.println(c*c);
		System.out.println(d);
		System.out.println(d*d);
		System.out.println("Float.MAX_VALUE: " + Float.MAX_VALUE);
		System.out.println(Float.MAX_VALUE + 1.0f);
		System.out.println(Float.MAX_VALUE + 1.0);

		int num1 = 10;
		double num2 = 11.1;
		System.out.println("double - integer: " + (num2 - num1));
	}
}