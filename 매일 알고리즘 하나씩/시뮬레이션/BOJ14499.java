package everyday.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
	static int N, M;
	static int[][] map;
	static int[] dice = {0, 0, 0, 0, 0, 0};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	int x = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
		st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < K; i++) {
    		int dir = Integer.parseInt(st.nextToken());
    		if(dir == 4) {
    			y++;
    			if(y >= N) {
    				y--;
    				continue;
    			}
    			move(4, y, x);
    		}
    		else if(dir == 3) {
    			y--;
    			if(y < 0) {
    				y++;
    				continue;
    			}
    			move(3, y, x);
    		}
    		else if(dir == 1) {
    			x++;
    			if(x >= M) {
    				x--;
    				continue;
    			}
    			move(1, y, x);
    		}
    		else if(dir == 2) {
    			x--;
    			if(x < 0) {
    				x++;
    				continue;
    			}
    			move(2, y, x);
    		}
    		sb.append(dice[0]).append('\n');
    	}
    	System.out.println(sb);
    }
    
	private static void move(int dir, int y, int x) {
		int tmp = dice[0];
		if(dir == 4) { // 남
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = tmp;
		}
		else if(dir == 3) { // 북
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = tmp;
		}
		else if(dir == 1) { // 동
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = tmp;
		}
		else if(dir == 2) { // 서
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = tmp;
		}
		
		if(map[y][x] != 0) {
			dice[5] = map[y][x];
			map[y][x] = 0;
		}
		else {
			map[y][x] = dice[5];
		}
	}
}
