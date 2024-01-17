import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		List<Character> list = new LinkedList<>();

		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		ListIterator<Character> listIter = list.listIterator();

		while (listIter.hasNext()) listIter.next();

		int N = Integer.parseInt(br.readLine());
		while (N > 0) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			if (order.equals("L") && listIter.hasPrevious()) {
				listIter.previous();
			} else if (order.equals("D") && listIter.hasNext()) {
				listIter.next();
			} else if (order.equals("B") && listIter.hasPrevious()) {
				listIter.previous();
				listIter.remove();
			} else if (order.equals("P")) {
				listIter.add(st.nextToken().charAt(0));
			}

			N--;
		}

		for (Character c: list) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}