import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> cards = new HashMap<>();
		int max = 0;
		long res = 0;
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			cards.put(num, cards.getOrDefault(num, 0) + 1);

			int cnt = cards.get(num);
			if (cnt > max) {
				max = cards.get(num);
				res = num;
			} else if (cnt == max) {
				res = Math.min(res, num);
			}
		}

		System.out.println(res);
	}
}