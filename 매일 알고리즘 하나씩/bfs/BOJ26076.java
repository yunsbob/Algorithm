package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26076 {
	static int N, M, res = 2;
	static int[][] map;
	static int[][] dr = {{1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1; i < M; i++) {
        	if(map[0][i] == 1) {
        		numbering(0, i);
        	}
        }
        for(int i = 1; i < N - 1; i++) {
        	if(map[i][M-1] == 1) {
        		numbering(i, M - 1);
        	}
        }
        if(N == 1 || M == 1) {
        	System.out.println(1);
        	System.exit(0);
        }
        if(res == 1) {
        	System.out.println(1);
        	System.exit(0);
        }
        for(int i = 1; i < N; i++) {
        	if(map[i][0] == 1) {
        		block(i, 0);
        	}
        }
        for(int i = 1; i < M - 1; i++) {
        	if(map[N-1][i] == 1) {
        		block(N - 1, i);
        	}
        }
        
        System.out.println(res);
    }

	private static void block(int y, int x) {
		map[y][x] = 3;
		for(int i = 0; i < 8; i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx == M - 1 || ny == 0) {
				System.out.println(1);
				System.exit(0);
			}
			if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			if(map[ny][nx] == 1) block(ny, nx);
			if(map[ny][nx] == 0) check(ny, nx);
		}
	}

	private static void check(int y, int x) {
		map[y][x] = 9;
		for(int i = 0; i < 8; i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] == 3) continue;
			if(map[ny][nx] == 2) {
				System.out.println(1);
				System.exit(0);
			}
		}
		
	}

	private static void numbering(int y, int x) {
		map[y][x] = 2;
		if(x == 0 || y == N - 1) {
			System.out.println(0);
			System.exit(0);
		}
		for(int i = 0; i < 8; i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx == 0 || ny == N - 1) res = 1;
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] != 1) continue;
			numbering(ny, nx);
		}
	}
}
