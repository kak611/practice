import java.util.Arrays;
class ReverseWords {
	public static void main(String[] args) {
 		//String str1 = "Alice likes Bob";
 		String str1 = "When you are happy and you know it clap your hands";

 		char[] arr = str1.toCharArray();
 		// reverse entire string including spaces
		reverse(arr, 0, arr.length-1);		

 		// reverse each word within the string
		reverseWords(arr);
		
		System.out.println(arr);
	}

	public static void reverse(char[] str, int start, int end) {
		//if (str.length <= 1) return;
		if (start >= end) return;		
		for (int i=start; i <= start + (end - start)/2; ++i) {
			// swap
			char temp = str[i];
			str[i] = str[end - i + start]; // add start to adjust pointer to appropriate position
			str[end - i + start] = temp;
		}		
	}

	public static void reverseWords(char[] str) {

		int start = 0;
		int end;		

		while((end = find(str, start, ' ')) != -1) {			
			reverse(str, start, end-1);
			start = end + 1;			
		}

		// reverse the last word
		reverse(str, start, str.length-1);
	}

	public static int find(char[] str, int start, char c) {
		for (int i=start; i< str.length; i++) {
			if(str[i] == c) {				
				return i;
			}
		}
		return -1;
	}
}



// class ReverseWords {
// 	public static void main(String[] args) {
// 		String str1 = "Alice likes Bob";
// 		String str2 = "When you are happy and you know it clap your hands!!";
// 		String[] arr = str2.split(" ");
// 		System.out.println(reverseWords(arr));		
// 	}

// 	public static String reverseWords(String[] arr) {
// 		if (arr.length == 0) return "";
// 		return arr[arr.length-1] + " " + reverseWords(Arrays.copyOfRange(arr, 0, arr.length-1));
// 	}
// }