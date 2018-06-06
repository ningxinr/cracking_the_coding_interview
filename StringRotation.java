import java.util.*;

class StringRotation {
	private static boolean isStringRotation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (str2.contains(str1.substring(0,i)) 
					&& str2.contains(str1.substring(i))) {
				return true;
			}	
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isStringRotation("abc", "bca"));
		System.out.println(isStringRotation("abc", "cab"));
		System.out.println(isStringRotation("abc", "cba"));
		System.out.println(isStringRotation("waterbottle", "erbottlewat"));
	}
}
