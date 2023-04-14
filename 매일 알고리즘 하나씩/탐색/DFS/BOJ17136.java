package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {
	static boolean[][] paper = new boolean[100][100];
	static int[] paperCnt = {0, 5, 5, 5, 5, 5}; // 색종이 1 ~ 5 size 각 5장 씩 존재
	static int pCnt = 0, res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				if(st.nextToken().equals("1")) {
					paper[i][j] = true;
					pCnt++;
				}
			}
		}
		
		search(0, 0, 0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {			
			System.out.println(res);
		}
	}

	/**
	 * 색종이 DFS 탐색
	 * @param y
	 * @param x
	 * @param cnt - 현재 쓰인 색종이 수
	 */
	private static void search(int y, int x, int cnt) { // 색종이 붙일 수 있는 위치 탐색
		if(res <= cnt) return; // 최소보다 색종이를 더 쓴 경우 더 이상 볼 필요없음
		if(pCnt == 0) { // 색종이를 다 붙인 경우 값 입력
			res = cnt;
			return;
		}
		if(y > 9) { // 종이를 넘어버린 경우 탐색 x
			return;
		}
		if(x > 9) { // 가로로 다 봤으면 세로로 다음 칸 이동
			search(y + 1, 0, cnt);
			return;
		}
		if(paper[y][x]) { // 색종이를 붙일 위치
			for(int size = 5; size > 0; size--) { // 5부터 1 사이즈까지 종이 확인
				if(paperCnt[size] == 0) continue; // 해당 색종이가 존재하지 않으면 사용 x
				if(check(y, x, size)) { // 색종이 사용 가능한지 확인
					attach(y, x, size); // 붙임
					pCnt -= size * size; // 색종이 붙일 수 있는 칸 줄임
					search(y, x + size, cnt + 1); // 가로 이동 후 탐색, 쓴 색종이 수 추가
					detach(y, x, size);
					pCnt += size * size;
				}
			}
			return;
		}
		search(y, x + 1, cnt); // 가로 이동 후 탐색
	}
	
	private static boolean check(int y, int x, int size) { // 색종이 붙일 수 있는지 확인
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				if(i >= 10 || j >= 10 || !paper[i][j]) return false; // x, y 좌표가 10이상 되버리거나 못 붙이는 위치면 못 붙임
			}
		}
		return true;
	}

	private static void attach(int y, int x, int size) { // 색종이 붙이기
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				paper[i][j] = false;
			}
		}
		paperCnt[size]--; // 해당 사이즈 색종이 사용
	}
	
	private static void detach(int y, int x, int size) { // 색종이 떼기
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				paper[i][j] = true;
			}
		}
		paperCnt[size]++;
	}
}