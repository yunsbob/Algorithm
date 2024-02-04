import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int A, B;
	private static int[][] map;
	private static int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static List<Robot> robots;

	private static class Robot {
		int x, y, dir;

		Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		void turnR(int cnt) {
			this.dir = (this.dir + cnt) % 4;
		}

		void turnL(int cnt) {
			this.dir = (this.dir + 100 - cnt) % 4;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[B + 1][A + 1];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		robots = new ArrayList<>();
		robots.add(new Robot(0, 0, 0));
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			map[y][x] = i;

			if (s.equals("N"))
				robots.add(new Robot(x, y, 0));
			else if (s.equals("E"))
				robots.add(new Robot(x, y, 1));
			else if (s.equals("S"))
				robots.add(new Robot(x, y, 2));
			else
				robots.add(new Robot(x, y, 3));
		}

		String res = "OK";
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());

			if (order.equals("R")) {
				robots.get(num).turnR(cnt);
			}
			else if (order.equals("L")) {
				robots.get(num).turnL(cnt);
			}
			else {
				map[robots.get(num).y][robots.get(num).x] = 0;
				int status = run(robots.get(num).x, robots.get(num).y, robots.get(num).dir, 0, cnt, num);
				if (status == 101) {
					res = "Robot " + num + " crashes into the wall";
					break;
				}
				else if (status != 0) {
					res = "Robot " + num + " crashes into robot " + status;
					break;
				}
			}
		}

		System.out.println(res);
	}

	private static int run(int nowX, int nowY, int dir, int cnt, int max, int num) {
		if (nowX <= 0 || nowY <= 0 || nowX > A || nowY > B) {
			return 101;
		}
		else if (map[nowY][nowX] != 0) {
			return map[nowY][nowX];
		}

		if (cnt == max) {
			robots.get(num).x = nowX;
			robots.get(num).y = nowY;
			map[nowY][nowX] = num;
			return 0;
		}
		else {
			return run(nowX + dr[dir][0], nowY + dr[dir][1], dir, cnt + 1, max, num);
		}
	}
}