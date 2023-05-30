package everyday.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
	static int N;
	static int resultW = 0, resultB = 0;
	static int[][] arr;
	
	public static void blueCount(int size, int y, int x) {
		if(size == 1 && arr[y][x] == 1) {
			resultB++;
			return;
		}
		else if(size == 1 && arr[y][x] == 0) {
			resultW++;
			return;
		}
		A: for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
					if(arr[i][j] == 0) {
						break A;
					}
			}
			if(i == y + size - 1) {
				resultB++;
				return;
			}
		}
		B: for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
					if(arr[i][j] == 1) {
						break B;
					}
			}
			if(i == y + size - 1) {
				resultW++;
				return;
			}
		}
		blueCount(size / 2, y, x);
		blueCount(size / 2, y, x + size / 2);
		blueCount(size / 2, y + size / 2, x);
		blueCount(size / 2, y + size / 2, x + size / 2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		blueCount(N, 0, 0);
		sb.append(resultW).append('\n').append(resultB);
		System.out.println(sb);
	}

}
