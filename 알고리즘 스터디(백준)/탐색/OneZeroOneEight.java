import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class OneZeroOneEight {
	public static int count(boolean[][] arr1, int n, int m, boolean chk) {
		int cnt = 0;
		boolean[][] arr = new boolean[8][8];
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				arr[y][x] = arr1[y+n][x+m];
			}
		}

		if(arr[0][0] != chk) {
			arr[0][0] = chk;
			cnt++;
		}
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				if(x == 0 && y == 0) {
					continue;
				}
				else if(x == 0 && arr[y-1][x] == arr[y][x]) {
					cnt++;
					arr[y][x] = !arr[y-1][x];
				}
				else if(x == 0 && arr[y-1][x] != arr[y][x]) {
					continue;
				}
				else if(arr[y][x-1] == arr[y][x]) {
					cnt++;
					arr[y][x] = !arr[y][x-1];
				}
				else if(arr[y][x-1] != arr[y][x]) {
					continue;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String s;
		int Wcnt, Bcnt;
		int result = 32;
		
		boolean[][] arr = new boolean[N][M];
		for(int y = 0; y < N; y++) {
			s = br.readLine();
			for(int x = 0; x < M; x++) {
				if(s.charAt(x) == 'W') {
					arr[y][x] = true;
				}
				else {
					arr[y][x] = false;
				}
			}
		}
		for(int y = 0; y <= N - 8; y++) {
			for(int x = 0; x <= M-8; x++) {
					Wcnt = count(arr, y, x, true);
					Bcnt = count(arr, y, x, false);
					if(result > Wcnt) {
						result = Wcnt;
					}
					if(result > Bcnt) {
						result = Bcnt;
					}
				}
		}
		sb.append(result);
		System.out.println(sb);
	}
}