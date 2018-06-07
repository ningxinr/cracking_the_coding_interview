import java.util.*;

public class CheckPermutations {
	private static Boolean checkPermutations(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		String sortedStr1 = sort(str1);
		String sortedStr2 = sort(str2);
		return sortedStr1.equals(sortedStr2);
	}

	private static String sort(String str) {
		char c[] = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	public static void main(String[] args) {
		System.out.println(checkPermutations("Hello World!", "World Hello!"));
		System.out.println(checkPermutations("Hello World!", "World Hellp!"));
	}
}
