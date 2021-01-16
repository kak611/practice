
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Student implements Comparable<Student> {
	String name;
	double gradePointAverage;

	public Student(String name, double gradePointAverage) {
		this.name = name;
		this.gradePointAverage = gradePointAverage;
	}

	public int compareTo(Student student) {
		return name.compareTo(student.name);
	}

	public static void sortByName(List<Student> students) {
		// natural ordering as defined above in compareTo()
		Collections.sort(students);
	}

	public static void sortByGPA(List<Student> students) {
		Collections.sort(students, Collections.reverseOrder(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				// return in reverse order. So output is revese of reverse i.e ascending order OR remove collections.reverseOrder
				//return s1.gradePointAverage > s2.gradePointAverage ? -1 : (s1.gradePointAverage < s2.gradePointAverage ? 1 : 0);
				return Double.compare(s1.gradePointAverage, s2.gradePointAverage);
			}
		}));
	}

	public String toString() {
		return name + " " + gradePointAverage;
	}

	public static void main(String[] args) {		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Alex", 3.30));
		list.add(new Student("Leo", 3.98));
		list.add(new Student("Usain", 3.467));
		list.add(new Student("Caitlin", 3.78));
		list.add(new Student("Naomi", 3.22));

		System.out.println(list);
		Student.sortByGPA(list);
		System.out.println("By GPA: " + list);
		Student.sortByName(list);
		System.out.println("By Name: " + list);
	}
}