package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {
	static int[][] fish; // 맵
	static boolean[][] visited; // 방문 여부
	static int[] shark = new int[8]; // 아기상어 경험치
	static int level = 2, N, cntAll = 0; // 아기상어 사이즈, 맵크기 NxN, 모든 물고기 수
	static Queue<Integer> qXY = new LinkedList<Integer>(); // 좌표
	static Queue<Integer> qSec = new LinkedList<Integer>(); // 시간
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int x = 0, y = 0, second = 0, nX, nY, nS;
	
	public static void BFS() { // qXY는 무조건 x, y순서대로 IO
		qXY.offer(x);
		qXY.offer(y);
		qSec.offer(second);
		int sec;
		while(!qXY.isEmpty()) {
			x = qXY.poll();
			y = qXY.poll();
			visited[y][x] = true;
			sec = qSec.poll() + 1;
			if(nS != -1 && nS < sec) {
				return;
			}
			for(int i = 0; i < 4; i++) { // 4 방향 이동
				int mX = x + dx[i];
				int mY = y + dy[i];
				if(mX >= 0 && mY >= 0 && mX < N && mY < N && fish[mY][mX] <= level && !visited[mY][mX]) { // 물고기 크기가 상어보다 크지 않고 방문한적 없을 때
					qXY.offer(mX);
					qXY.offer(mY);
					qSec.offer(sec); // 1초 지남
					visited[mY][mX] = true; // 방문
					if(fish[mY][mX] > 0 && fish[mY][mX] < level) { // 내가 먹을 수 있는 물고기 존재
						if(nX == -1) {
							nX = mX;
							nY = mY;
							nS = sec;
						}
						else if(nY > mY) {
							nX = mX;
							nY = mY; 
						}
						else if(nY == mY) {
							if(nX > mX) {
								nX = mX;
								nY = mY;
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		fish = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				fish[i][j] = Integer.parseInt(st.nextToken());
				if(fish[i][j] == 9) { // 아기 상어면 시작 좌표 설정하고 맵에는 0으로 표시
					y = i;
					x = j;
					fish[i][j] = 0;
				}
				else if(fish[i][j] > 0) { // 해당위치가 물고기면 모든 물고기 수랑 해당 사이즈 물고기 수 카운트
					cntAll++;
				}
			}
		}
		
		while(cntAll > 0) { // 물고기가 존재할 경우 탐색
			for(boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}
			qXY.clear();
			qSec.clear();
			nX = nY = nS = -1;
			BFS();
			if(nX == -1) { // 탐색 후 먹으러갈 물고기가 없으면 멈춤
				break;
			}
			else {
				x = nX;
				y = nY;
				second = nS;
				cntAll--; // 맵에 있는 전체 물고기 줄임
				fish[y][x] = 0; // 해당 칸 물고기 먹음
				shark[level]++; // 쿠아 경험치 얻음
				if(shark[level] == level && level < 7) { // 쿠아 경험치 맥스면 레벨업 최대레벨 7
					level++;
				}
			}
		}
		sb.append(second);
		System.out.println(sb);
	}
}