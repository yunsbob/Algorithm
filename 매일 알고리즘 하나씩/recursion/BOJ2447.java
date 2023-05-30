package everyday.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2447 {
	public static void Star(int size, String[][] s, int x, int y) {
		if(size == 1) {
			s[y][x] = "*";
		}
		else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(!(i == 1 && j == 1)) {
						Star(size / 3, s, x + size / 3 * i, y + size / 3 * j);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] s = new String[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				s[i][j] = " ";
			}
		}
		
		Star(n, s, 0, 0);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
					bw.write(s[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
	}
}