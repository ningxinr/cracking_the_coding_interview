import java.util.*;
import java.lang.*;

class StringCompression {
	private static String stringCompression(String str) {
		StringBuilder strBuilder = new StringBuilder();
		String prevChar = str.substring(0, 1);
		int cnt = 0;
		for (int i=0; i < str.length(); i++) {
			String currChar = str.substring(i, i+1);
			if (!currChar.equals(prevChar)) {
				strBuilder.append(prevChar);
				strBuilder.append(cnt);
				prevChar = currChar;
				cnt = 1;
			} else {
				cnt++;
			}
		}
		strBuilder.append(prevChar);
		strBuilder.append(cnt);
		String comp_str = strBuilder.toString(); 
		return (comp_str.length() > str.length()) ? str : comp_str;
	}

	public static void main(String[] args) {
		System.out.println(stringCompression("Hello World!"));
		System.out.println(stringCompression("aabcccccaaa"));
		System.out.println(stringCompression("abcbabcbabc"));
	}
}
