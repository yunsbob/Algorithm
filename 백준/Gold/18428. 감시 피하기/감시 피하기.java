import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static String[][] map;
	private static List<XY> flag = new ArrayList<>();
	private static List<XY> teachers = new ArrayList<>();

	private static class XY {
		int x, y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new String[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String s = st.nextToken();

				if (s.equals("T"))
					teachers.add(new XY(i, j));
				else if (s.equals("X"))
					flag.add(new XY(i, j));

				map[i][j] = s;
			}
		}

		if (blocking())
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static boolean blocking() {
		for (int i = 0; i < flag.size(); i++) {
			map[flag.get(i).x][flag.get(i).y] = "B";
			for (int j = i + 1; j < flag.size(); j++) {
				map[flag.get(j).x][flag.get(j).y] = "B";
				for (int k = j + 1; k < flag.size(); k++) {
					map[flag.get(k).x][flag.get(k).y] = "B";

					if (!watch())
						return true;

					map[flag.get(k).x][flag.get(k).y] = "X";
				}
				map[flag.get(j).x][flag.get(j).y] = "X";
			}
			map[flag.get(i).x][flag.get(i).y] = "X";
		}

		return false;
	}

	private static boolean watch() {
		for (XY teacher : teachers) {
			int x = teacher.x;
			int y = teacher.y;

			while (++x < N) {
				if (map[x][y].equals("B"))
					break;
				else if (map[x][y].equals("T"))
					break;
				else if (map[x][y].equals("S"))
					return true;
			}

			x = teacher.x;

			while (--x >= 0) {
				if (map[x][y].equals("B"))
					break;
				else if (map[x][y].equals("T"))
					break;
				else if (map[x][y].equals("S"))
					return true;
			}

			x = teacher.x;

			while (++y < N) {
				if (map[x][y].equals("B"))
					break;
				else if (map[x][y].equals("T"))
					break;
				else if (map[x][y].equals("S"))
					return true;
			}

			y = teacher.y;

			while (--y >= 0) {
				if (map[x][y].equals("B"))
					break;
				else if (map[x][y].equals("T"))
					break;
				else if (map[x][y].equals("S"))
					return true;
			}
		}

		return false;
	}
}