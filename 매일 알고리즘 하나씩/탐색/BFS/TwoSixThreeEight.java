import java.io.*;
import java.util.*;

public class TwoSixThreeEight {
	static int[][] cheese; // 치즈 모양
	static int N, M, cheeseCnt; // N: 세로, M: 가로, 치즈 개수
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Integer> qY = new LinkedList<>();
	static Queue<Integer> qX = new LinkedList<>();
	static Queue<Integer> XY = new LinkedList<>();
	
	public static void check(int y, int x) {  // 치즈가 녹는지 확인
		int cnt = 0;
		if(cheese[y-1][x] == 9) { // 상
			cnt++;
		}
		if(cheese[y+1][x] == 9) { // 하
			cnt++;
		}
		if(cheese[y][x-1] == 9) { // 좌
			cnt++;
		}
		if(cheese[y][x+1] == 9) { // 우
			cnt++;
		}
		if(cnt >= 2) { // 녹임
			XY.offer(x);
			XY.offer(y);
			cheese[y][x] = 0;
			cheeseCnt--;
		}
	}

	public static void outDFS(int y, int x) { // 외부 체크
		int mX, mY;
		cheese[y][x] = 9;
		for(int i = 0; i < 4; i++) {
			mX = x + dx[i];
			mY = y + dy[i];
			if(mX >= 0 && mY >= 0 && mX < M && mY < N && cheese[mY][mX] == 0) {
				outDFS(mY, mX);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		
		for(int y = 0; y < N; y++) { // 치즈 모양 입력
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < M; x++) {
				cheese[y][x] = Integer.parseInt(st.nextToken());
				if(cheese[y][x] == 1) { // 해당 좌표에 치즈를 입력하면
					cheeseCnt++;
				}
			}
		}
		
		outDFS(0 , 0);
		while(cheeseCnt != 0) {
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < M; x++) {
					if(cheese[y][x] == 1) {
						check(y, x);
					}
				}
			}
			while(!XY.isEmpty()) {
				int x = XY.poll();
				int y = XY.poll();
				if(cheese[y][x] == 0) {
					outDFS(y, x);
				}
			}
			result++; // 한 시간 지남
		}
		sb.append(result);
		System.out.println(sb);
	}
}