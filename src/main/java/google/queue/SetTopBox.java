package google.queue;

public class SetTopBox {

	static char[][] matrix = {
			{'a','b', 'c', 'd', 'e'},
			{'f', 'g', 'h', 'i', 'j'},
			{'k', 'l', 'm', 'n', 'o'},
			{'p', 'q', 'r', 's', 't'},
			{'u', 'v', 'w', 'x', 'y'},
			{'z'}
	};


	public static String getPath(int w, char[] str) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		int curR = 0;
		int curC = 0;
		while (i < str.length) {
			int destR = (str[i] - 'a') / w;
			int destC = (str[i] - 'a') % w;

			while (curC > destC) {
				sb.append('L');
				curC--;
			}

			while (curR > destR) {
				sb.append('U');
				curR--;
			}

			while (curC < destC) {
				sb.append('R');
				curC++;
			}

			while (curR < destR) {
				sb.append('D');
				curR++;
			}

			sb.append('|');
			i++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getPath(5, "eat".toCharArray()));
	}
}
