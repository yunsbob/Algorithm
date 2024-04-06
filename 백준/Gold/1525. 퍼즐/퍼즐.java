import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				str.append(st.nextToken());
			}
		}

		if (str.toString().equals("123456780")) {
			System.out.println(0);
		} else {
			System.out.println(bfs(str.toString()));
		}
	}

	private static int bfs(String input) {
		Map<String, Integer> nums = new HashMap<>();
		Queue<String> q = new ArrayDeque<>();
		int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		String end = "123456780";
		nums.put(input, 0);
		q.add(input);

		while (!q.isEmpty()) {
			String now = q.poll();
			int cnt = nums.get(now) + 1;
			int pos = now.indexOf("0");
			int x = pos / 3;
			int y = pos % 3;

			for (int i = 0; i < 4; i++) {
				int nx = x + dxy[i][0];
				int ny = y + dxy[i][1];

				if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3)
					continue;

				int nPos = nx * 3 + ny;
				StringBuilder next = new StringBuilder(now);
				next.setCharAt(pos, now.charAt(nPos));
				next.setCharAt(nPos, '0');

				String str = next.toString();
				if (end.equals(str)) {
					return cnt;
				} else if (!nums.containsKey(str)) {
					nums.put(str, cnt);
					q.offer(str);
				}
			}
		}

		return -1;
	}
}