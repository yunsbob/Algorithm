package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14939 {
	static int res = Integer.MAX_VALUE;
	static boolean[][] arr = new boolean[10][10];
	static boolean[][] map = new boolean[10][10];
	static boolean[] check = new boolean[10];
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < 10; i++) {
        	String str = br.readLine();
        	for(int j = 0; j < 10; j++) {
        		if(str.charAt(j) == 'O') arr[i][j] = true;
        	}
        }
        
        check(0, 0);
        
        if(res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res);
    }
	private static void check(int idx, int cnt) {
		if(idx == 10) {
			for(int i = 0; i < 10; i++) {
				map[i] = arr[i].clone();
			}
			for(int i = 0; i < 10; i++) {
				if(check[i]) touch(0, i);
			}
			lightOff(cnt);
		}
		else {
			check[idx] = false;
			check(idx + 1, cnt);
			check[idx] = true;
			check(idx + 1, cnt + 1);
		}
	}
	private static void lightOff(int cnt) {
		for(int i = 1; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i-1][j]) {
					cnt++;
					touch(i, j);
				}
			}
		}
		
		boolean flag = true;
		for(int i = 0; i < 10; i++) {
			if(map[9][i]) flag = false;
		}
		if(flag) {
			res = Math.min(res, cnt);
		}
	}
	
	private static void touch(int i, int j) {
		map[i][j] = !map[i][j];
		if(i - 1 >= 0) map[i-1][j] = !map[i-1][j];
		if(j - 1 >= 0) map[i][j-1] = !map[i][j-1];
		if(j + 1 < 10) map[i][j+1] = !map[i][j+1];
		if(i + 1 < 10) map[i+1][j] = !map[i+1][j];
	}
}
