package everyday.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15685 {
	static int N;
	static boolean[][] map;
	static List<Integer> dragon = new ArrayList<>();
	static int[][] dxy = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			curve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int res = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j]) {
					if(map[i+1][j] && map[i][j+1] && map[i+1][j+1]) res++;
				}
			}
		}
		System.out.println(res);
	}

	private static void curve(int x, int y, int d, int g) {
		dragon.add(d);
		
		map[y][x] = true;
		for(int i = 0; i < g; i++) {
			for(int j = dragon.size() - 1; j >= 0; j--) {
				dragon.add((dragon.get(j) + 1) % 4);
			}
		}
		
		for(Integer yong : dragon) {
			x += dxy[yong][0];
			y += dxy[yong][1];
			map[y][x] = true;
		}
		dragon.clear();
	}
}