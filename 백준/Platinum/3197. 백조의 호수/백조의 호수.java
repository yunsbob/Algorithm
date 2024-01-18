import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, er, ec;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static Queue<XY> swan = new ArrayDeque<>();
	private static Queue<XY> ice = new ArrayDeque<>();

	private static class XY {
		int x, y;
		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		boolean flag = true;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					if (flag) {
						flag = false;
						visited[i][j] = true;
						swan.add(new XY(i, j));
					}
					else {
						er = i;
						ec = j;
					}
					ice.add(new XY(i, j));
					map[i][j] = '.';
				} else if (map[i][j] == '.') {
					ice.add(new XY(i, j));
				}
			}
		}

		int res = 0;
		while (!move()) {
			melt();
			res++;
		}

		System.out.println(res);
	}

	private static boolean move() {
		Queue<XY> nq = new ArrayDeque<>();
		while (!swan.isEmpty()) {
			XY now = swan.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				if (nx == er && ny == ec) return true;
				else if (map[nx][ny] == 'X') {
					nq.add(new XY(nx, ny));
				}
				else {
					swan.add(new XY(nx, ny));
				}
			}
		}

		swan = nq;
		
		return false;
	}

	private static void melt() {
		int size = ice.size();
		while (size-- > 0) {
			XY now = ice.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '.') continue;
				map[nx][ny] = '.';
				ice.add(new XY(nx, ny));
			}
		}
	}
}