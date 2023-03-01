package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17281 {
	static int inn, result = 0; // 이닝, 결과
	static int[][] player; // 선수들
	static int[] select = new int[10]; // 타순
	static boolean[] check = new boolean[10]; // 이미 입력한 선수인지 확인
	static boolean[] base = new boolean[4]; // 1~3루에 주자 존재하는지 확인, 0은 dummy
	
	static void play() {
		int out, now = 1, score = 0; // 아웃 카운트, 몇번 타자인지, 점수
		for(int i = 1; i <= inn; i++) { // 모든 이닝 종료시까지
			out = 0;
			Arrays.fill(base, false); // 이닝 시작전 주자 초기화
			while(out != 3) { // 아웃 카운트가 3이면 이닝 종료
				if(player[i][select[now]] == 0) {
					out++;
				}
				else if(player[i][select[now]] == 1) { // 안타일때
					for(int j = 3; j > 0; j--) {
						if(j == 3 && base[3]) {
							base[j] = false;
							score++;
						}
						else if(base[j]) {
							base[j] = false;
							base[j+1] = true;
						}
					}
					base[1] = true;
				}
				else if(player[i][select[now]] == 2) { // 2루타일때
					for(int j = 3; j > 0; j--) {
						if(j == 3 && base[3] || j == 2 && base[2]) {
							base[j] = false;
							score++;
						}
						else if(base[j]){
							base[j] = false;
							base[j+2] = true;
						}
					}
					base[2] = true;
				}
				else if(player[i][select[now]] == 3) { // 3루타일때
					for(int j = 3; j > 0; j--) {
						if(base[j]) {
							base[j] = false;
							score++;
						}
					}
					base[3] = true;
				}
				else if(player[i][select[now]] == 4) {
					for(int j = 3; j > 0; j--) {
						if(base[j]) {
							base[j] = false;
							score++;
						}
					}
					score++;
				}
				now++; // 다음 타자로
				if(now == 10) { // 다 돌았으면 다시 1번 타자
					now = 1;
				}
			}
		}
		result = Math.max(result, score);
	}

	static void select(int now) {
		if(now == 10) { // 타순 전부 입력 완료시
			play(); // 야구 시작
			return;
		}
		if(now == 4) {
			select(now + 1); // 4번 타자는 스킵
			return;
		}
		for(int i = 1; i <= 9; i++) { // 1~9번 타자까지 라인업에 입력
			if(!check[i]) {
				check[i] = true;
				select[now] = i;
				select(now + 1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		inn = Integer.parseInt(br.readLine());
		player = new int[inn+1][10];
		
		for(int i = 1; i <= inn; i++) { // 이닝별 선수들 결과 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) { // i번 이닝에 j번 선수 결과
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		select[4] = 1; // 4번 타자는 1번 선수로 고정
		check[1] = true; // 고정했으므로 선택못하게 막음
		select(1);
		System.out.println(result);
	}
}