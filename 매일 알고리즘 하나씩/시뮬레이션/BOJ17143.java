package everyday.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17143 {
	static int R, C, res = 0;
	static Shark[][] map;
	static Shark[][] clone;
	
	static class Shark {
		int s, d, z;

		Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	private static void move(int x) {
		for(int y = 1; y <= R; y++) {
			if(map[y][x] != null) {
				res += map[y][x].z;
				map[y][x] = null;
				return;
			}
		}
	}
	
	private static void swim() {
		for(int i = 1; i <= R; i++) {
			Arrays.fill(clone[i], null);
		}
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(map[i][j] != null) {
					int d = map[i][j].d;
					int s = map[i][j].s;
					int nx = j;
					int ny = i;
					while(s != 0) {
						if(ny == 1 && d == 1) {
							d = 2;
						}
						else if(ny == R && d == 2) {
							d = 1;
						}
						else if(nx == C && d == 3) {
							d = 4;
						}
						else if(nx == 1 && d == 4) {
							d = 3;
						}
						if(d == 1) {
							ny--;
						}
						else if(d == 2) {
							ny++;
						}
						else if(d == 3) {
							nx++;
						}
						else if(d == 4) {
							nx--;
						}
						s--;
					}
					if(clone[ny][nx] == null || clone[ny][nx].z < map[i][j].z) {
						clone[ny][nx] = new Shark(map[i][j].s, d, map[i][j].z);
					}
				}
			}
		}
		
		for(int i = 1; i <= R; i++) {
			map[i] = clone[i].clone();
		}
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new Shark[R+1][C+1];
    	clone = new Shark[R+1][C+1];
    	int M = Integer.parseInt(st.nextToken());

    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
        	map[r][c] = new Shark(s, d, z);
    	}
    	
    	
    	for(int x = 1; x <= C; x++) {
    		move(x);
    		swim();
    	}
    	System.out.println(res);
	}
}