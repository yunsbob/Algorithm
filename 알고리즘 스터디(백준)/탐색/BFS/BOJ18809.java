package everyday.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18809 {
	static int N, M, G, R, res = 0;
	static int[][] arr;
	static int[][] dr = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static List<XY> broth = new ArrayList<>(); // 배양액을 뿌릴 수 있는 땅 좌표리스트
	static List<XY> choiceG = new ArrayList<>(); // 초록색 배양액을 뿌린 땅 좌표리스트
	static List<XY> choiceR = new ArrayList<>(); // 빨간색 배양액을 뿌린 땅 좌표리스트
	
	private static class XY{
		int x, y;
		private XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 2) { // 배양액을 뿌릴 수 있는 땅이므로 broth에 좌표 넣음
        			broth.add(new XY(j, i));
        		}
        	}
        }
        select(0, 0, 0, 0);

        System.out.println(res);
    }

	private static void select(int idx, int cnt, int g, int r) {
		if(cnt == G + R) { // 모든 배양액을 다 썼을 경우
			BFS();
		}
		else {
			for(int i = idx; i < broth.size(); i++) {
				if(g < G) { // 초록색 배양액을 뿌릴 수 있는 경우
					choiceG.add(broth.get(i));
			        select(i + 1, cnt + 1, g + 1, r);
					choiceG.remove(choiceG.size() - 1);
				}
				if(r < R) { // 빨간색 배양액을 뿌릴 수 있는 경우
					choiceR.add(broth.get(i));
			        select(i + 1, cnt + 1, g, r + 1);
					choiceR.remove(choiceR.size() - 1);
				}
			}
		}
	}

	private static void BFS() {
		int[][] map = new int[N][M];
		int[][] cnt = new int[N][M]; // 해당 땅에 도착한 시간 입력받을 배열
		int nowRes = 0;
		Queue<XY> q = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) { // 새로운 맵 생성
			map[i] = arr[i].clone();
		}
		for(XY n : choiceG) { // 초록색 배양액을 뿌린 땅은 8로 입력
			q.offer(new XY(n.x, n.y));
			map[n.y][n.x] = 8;
		}
		for(XY n : choiceR) { // 빨간색 배양액을 뿌린 땅은 9로 입력
			q.offer(new XY(n.x, n.y));
			map[n.y][n.x] = 9;
		}
		
		while(!q.isEmpty()) {
			XY now = q.poll();
			if(map[now.y][now.x] == -1) continue; // 현재 땅이 꽃이면 탐색x
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dr[i][0];
				int ny = now.y + dr[i][1];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] == 0 || map[ny][nx] == -1) continue;
				if(map[ny][nx] == 2 || map[ny][nx] == 1) { // 배양액이 퍼질 수 있는 땅이면 퍼짐
					q.offer(new XY(nx, ny));
					map[ny][nx] = map[now.y][now.x];
					cnt[ny][nx] = cnt[now.y][now.x] + 1;
				}
				if(map[ny][nx] == 8 && map[now.y][now.x] == 9 && // 현재 땅이 빨간색이고 다음 땅이 초록색 이며
						cnt[now.y][now.x] + 1 == cnt[ny][nx]) { // 동일한 시간대라면 꽃이 핌
					map[ny][nx] = -1; // 꽃은 -1로 입력
					nowRes++; 
				}
			}
		}

		res = Math.max(res, nowRes);
	}
}