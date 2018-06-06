import java.util.*;

class URLify {
	private static char[] urlify(char[] str, int len) {
		int cnt_space = 0;
		for (int i = 0; i < len; i++) {
			if (str[i] == ' ') {
				cnt_space++;
			}
		}
		for(int i = (len + cnt_space*2 - 1); i > 0; i--) {
			if (str[i - cnt_space*2] != ' '){
				str[i] = str[i - cnt_space*2];
			} else {
				str[i--] = '0';
				str[i--] = '2';
				str[i--] = '%';
				cnt_space--;
			}
		}
		return str;
	}

	public static void main(String[] args) {
		String hello = "Hello World!  ";
		System.out.println(urlify(hello.toCharArray(), hello.trim().length()));
	}
}
