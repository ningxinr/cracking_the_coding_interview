import java.util.*;

class StringRotation {
	private static boolean isStringRotation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		String str = str2 + str2;
		return str.contains(str1);

	}

	public static void main(String[] args) {
		System.out.println(isStringRotation("abc", "bca"));
		System.out.println(isStringRotation("abc", "cab"));
		System.out.println(isStringRotation("abc", "cba"));
		System.out.println(isStringRotation("waterbottle", "erbottlewat"));
	}
}
