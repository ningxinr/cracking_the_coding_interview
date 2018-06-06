import java.util.*;
import java.lang.*;

class PalindromePermutation {
	private static Boolean parlindromePermutation(char[] str) {
		for (int i = 0; i < str.length; i++) {
			if (Character.isLetter(str[i]) && Character.isUpperCase(str[i])) {
				str[i] = Character.toLowerCase(str[i]);
			}
		}
		Arrays.sort(str);
		int cnt_odd = 0;
		int cnt = 0;
		char pre_c = str[0];
		for (char c : str) {
			if (c != ' ') {
				if (c != pre_c) {
					pre_c = c;
					cnt_odd += (cnt%2 == 0)? 0 : 1;
					cnt = 1;
					if (cnt_odd > 1) {
						break;
					}
				} else {
					cnt++;
				}
			}
		}
		return cnt_odd < 2;
	}

	public static void main(String[] args) {
		System.out.println(parlindromePermutation("Hello World!".toCharArray()));
		System.out.println(parlindromePermutation("Tact Coa".toCharArray()));
	}
}
