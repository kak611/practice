import java.util.*;

class StudentGPA {
	public static void main(String[] args) {
		Students[] students = {
			new Students("gfhd", 2.7),
			new Students("zvg", 2.9),
			new Students("dafg", 3.22),			
			new Students("sfghd", 3.234),			
			new Students("dfgklj", 3.3333),
			new Students("werf", 3.75),
			new Students("abc", 3.9),					
			new Students("xyz", 3.86),
			new Students("lmn", 3.96),
			new Students("cool", 4.0)
		};
		
		List<Students> list = Arrays.asList(students);
		// Students s = new Students("aaa", 3.96);
		Students s = new Students("wow", 3.96);

		int index = Arrays.binarySearch(students, s, new Comparator<Students>() {
		// int index = Collections.binarySearch(list, s, new Comparator<Students>() {
			@Override
			public int compare(Students s1, Students s2) {
				if (s1.gpa == s2.gpa) {					
					return s1.name.compareTo(s2.name);
				}
				return Double.compare(s1.gpa, s2.gpa);
			}
		});

		System.out.println("Index: " + index);
	}

	static class Students {
		String name;
		double gpa;

		public Students(String name, double gpa) {
			this.name = name;
			this.gpa = gpa;
		}

		public String toString() {
			return name + " : " + gpa;
		}
	}
}