package everyday.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int K; // 명령어 수
	static int right, left;
	static int[][] order; // 명령어들을 입력받을 배열
	static List<LinkedList<Boolean>> gears = new ArrayList<>(); // 톱니 바퀴를 입력받을  덱 리스트
	
	static void check(int num) {
		left = right = num;
		
		while(right < 4) { // 오른쪽 톱니들 회전체크
			if(gears.get(right).get(2) == gears.get(right+1).get(6)) {
				break;
			}
			else {
				right++;
			}
		}
		
		while(left > 1) { // 왼쪽 톱니들 회전체크
			if(gears.get(left).get(6) == gears.get(left-1).get(2)) {
				break;
			}
			else {
				left--;
			}
		}
	}
	
	static void rotate(int num, int dr) { // num: 톱니 번호, dr: 방향
		check(num);
		
		int drRL = -dr;
		for(int i = num + 1; i <= right; i++) {
			if(drRL == 1) {
				gears.get(i).addFirst(gears.get(i).removeLast());
			}
			else {
				gears.get(i).addLast(gears.get(i).removeFirst());
			}
			drRL = -drRL;
		}
		
		drRL = -dr;
		for(int i = num - 1; i >= left; i--) {
			if(drRL == 1) {
				gears.get(i).addFirst(gears.get(i).removeLast());
			}
			else {
				gears.get(i).addLast(gears.get(i).removeFirst());
			}
			drRL = -drRL;
		}
		
		if(dr == 1) {
			gears.get(num).addFirst(gears.get(num).removeLast());
		}
		else {
			gears.get(num).addLast(gears.get(num).removeFirst());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String gear;
		int score = 1;
		int result = 0;
		
		gears.add(new LinkedList<Boolean>());
		for(int i = 1; i <= 4; i++) { // gear 1번부터 4번까지 입력
			gear = br.readLine();
			gears.add(new LinkedList<Boolean>());
			for(int j = 0; j < gear.length(); j++) {
				if(gear.charAt(j) == '1') {
					gears.get(i).add(true);
				}
				else {
					gears.get(i).add(false);
				}
			}
		}
		
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) { // 명령 입력
			st = new StringTokenizer(br.readLine());
			rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i <= 4; i++) {
			if(gears.get(i).get(0) == true) {
				result += score;
			}
			score *= 2;
		}
		
		System.out.println(result);
	}
}
