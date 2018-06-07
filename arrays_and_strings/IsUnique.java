import java.util.*;
import java.lang.*;

class IsUnique {
	private static Boolean isUnique(String str) {
		Map<String, Integer> charMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			String subStr = str.substring(i, i + 1);
			if (charMap.containsKey(subStr)) {
				Integer cnt = charMap.get(subStr);
				charMap.put(subStr, ++cnt);
			} else {
				charMap.put(subStr, 1);
			}

		}

		return !charMap.entrySet().stream()
			.anyMatch(e -> e.getValue() > 1);
	}

	public static void main(String[] args) {
	
		System.out.println(isUnique("Hello World!"));

	}
}
