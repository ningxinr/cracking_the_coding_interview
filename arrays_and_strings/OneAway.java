import java.util.*;
import java.lang.*;

class OneAway {
	private static Boolean oneAway(char[] str1, char[] str2) {
		if (Math.abs(str1.length - str2.length) > 1) {
			return false;
		}

		int cnt_diff = 0;
		int i = 0;
		int j = 0;
		while (i < str1.length && j < str2.length ){
			if (str1[i] != str2[j]) {
				if (i < (str1.length - 1) && str1[i+1] == str2[j]) {
					cnt_diff++;
					i++;
				} else if (j < (str2.length - 1) && str1[i] == str2[j+1]) {
					cnt_diff++;
					j++;
				} else if (i < (str1.length - 1) && j < (str2.length - 1) 
						&& str1[i+1] == str2[j+1]) {
					cnt_diff++;
					i++;
					j++;
				} else {
					return false;
				}
			} else {
				i++;
				j++;
			}
		}
		return cnt_diff < 2;
	}


	public static void main(String[] args) {
		System.out.println(oneAway("pale".toCharArray(), "ple".toCharArray()));
		System.out.println(oneAway("pales".toCharArray(), "pale".toCharArray()));
		System.out.println(oneAway("pale".toCharArray(), "bale".toCharArray()));
		System.out.println(oneAway("pale".toCharArray(), "bake".toCharArray()));
	}
}
