package study.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
	static int N, M, dr;
	static int clean = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map;

	public static void move(int y, int x) {
		if(map[y][x] == 0) {
			clean++;
			map[y][x] = 9;
		}
		for(int i = 0; i < 4; i++) {
			dr--;
			if(map[y+dy[dr%4]][x+dx[dr%4]] == 0) {
				move(y + dy[dr%4], x + dx[dr%4]);
			}
		}
		if(map[y-dy[dr%4]][x-dx[dr%4]] == 1) {
				System.out.println(clean);
				System.exit(0);
		}
		else {
			move(y - dy[dr%4], x - dx[dr%4]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		dr = Integer.parseInt(st.nextToken());
		dr += 800000000;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(startY, startX);
	}
}
