package everyday.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683 {
	static int N, M, num = 1, res = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] mapC;
	static List<CCTV> list = new ArrayList<>();
	
	static class CCTV{
		int num, dir; // 종류, 방향

		private CCTV(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapC = new int[N][M];
		
		list.add(new CCTV(0, 0));
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					list.add(new CCTV(map[i][j], 1));
					map[i][j] = num++;
				}
				else if(map[i][j] == 6) {
					map[i][j] = -1;
				}
			}
		}
		
		select(1);
		System.out.println(res);
	}

	private static void select(int cnt) {
		if(cnt == num) {
			surveillance();
		}
		else {
			if(list.get(cnt).num == 5) {
				select(cnt + 1);
			}
			else if(list.get(cnt).num == 2) {
				for(int i = 1; i <= 2; i++) {
					list.get(cnt).dir = i;
					select(cnt + 1);
				}
			}
			else {
				for(int i = 1; i <= 4; i++) {
					list.get(cnt).dir = i;
					select(cnt + 1);
				}
			}
		}
	}

	private static void surveillance() {
		for(int i = 0; i < N; i++) {
			mapC[i] = map[i].clone();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(mapC[i][j] > 0) {
					direction(mapC[i][j], j, i);
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(mapC[i][j] == 0) {
					ans++;
				}
			}
		}
		res = Math.min(res, ans);
	}

	private static void direction(int kind, int x, int y) {
		if(list.get(kind).num == 1) {
			watch(list.get(kind).dir, x, y);
		}
		else if(list.get(kind).num == 2) {
			watch(list.get(kind).dir, x, y);
			watch(list.get(kind).dir + 2, x, y);
		}
		else if(list.get(kind).num == 3) {
			watch(list.get(kind).dir, x, y);
			if(list.get(kind).dir + 1 == 5) {
				watch(1, x, y);
			}
			else {
				watch(list.get(kind).dir + 1, x, y);
			}
		}
		else if(list.get(kind).num == 4) {
			for(int i = 1; i <= 4; i++) {
				if(list.get(kind).dir == i) continue;
				watch(i, x, y);
			}
		}
		if(list.get(kind).num == 5) {
			watch(1, x, y);
			watch(2, x, y);
			watch(3, x, y);
			watch(4, x, y);
		}
	}

	private static void watch(int dir, int x, int y) {
		int nx = x;
		int ny = y;
		if(dir == 1) {
			nx++;
			while(nx < M) {
				if(mapC[y][nx] == 0) {
					mapC[y][nx] = -2;
					nx++;
				}
				else if(mapC[y][nx] == -1) {
					break;
				}
				else {
					nx++;
				}
			}
		}
		else if(dir == 2) {
			ny++;
			while(ny < N) {
				if(mapC[ny][x] == 0) {
					mapC[ny][x] = -2;
					ny++;
				}
				else if(mapC[ny][x] == -1) {
					break;
				}
				else {
					ny++;
				}
			}
		}
		else if(dir == 3) {
			nx--;
			while(nx >= 0) {
				if(mapC[y][nx] == 0) {
					mapC[y][nx] = -2;
					nx--;
				}
				else if(mapC[y][nx] == -1) {
					break;
				}
				else {
					nx--;
				}
			}
		}
		else if(dir == 4) {
			ny--;
			while(ny >= 0) {
				if(mapC[ny][x] == 0) {
					mapC[ny][x] = -2;
					ny--;
				}
				else if(mapC[ny][x] == -1) {
					break;
				}
				else {
					ny--;
				}
			}
		}
	}
}
