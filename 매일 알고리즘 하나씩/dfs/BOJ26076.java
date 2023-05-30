package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26076 {
	static int N, M, res = 2;
	static int[][] map;
	static int[][] dr = {{1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};
    
	/**
	 * 
	 * 기본 정답은 맨 끝이나 맨 처음을 기준으로 장애물 두개만 놓으면 되기에 최대 2
	 * 맨 위랑 맨 오른쪽부터 이어진 장애물은 2로 처리
	 * 맨 아래랑 맨 왼쪽부터 이어진 장애물은 3으로 처리
	 * 맨 위쪽이랑 맨 오른쪽부터 탐색할 때 맨 왼쪽이나 맨 아래에 도달하면 장애물 필요없음
	 * 맨 위쪽이랑 맨 오른쪽부터 탐색할 때 장애물 한개가 필요하다고 나오고 메인으로 돌아오면 정답은 한개
	 * 왜냐하면 맨 위쪽이랑 맨 오른쪽부터 탐색할 때 맨 왼쪽이나 맨 아래에 도달하지 못했다면 반대로해도 똑같음
	 * 맨 왼쪽이랑 맨 아래부터 탐색할 때는 0을 기준으로 체크해서 2로 된 장애물이 존재하면 정답은 1
	 * 2로 된 장애물이 존재하지 않아도 y 기준 0이나 x 기준 M - 2에 도달하면 정답은 1
	 * 
	 */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1; i < M; i++) { // 맨 위
        	if(map[0][i] == 1) {
        		numbering(0, i);
        	}
        }
        for(int i = 1; i < N - 1; i++) { // 맨 오른쪽
        	if(map[i][M-1] == 1) {
        		numbering(i, M - 1);
        	}
        }
        if(N == 1 || M == 1) { // 한 줄인데 numbering에서 안끝났으면 무조건 장애물 한개
        	System.out.println(1);
        	System.exit(0);
        }
        if(res == 1) { // numbering에서 끝나지 않았는데 장애물 한개가 가능하면 정답은 장애물 한개
        	System.out.println(1);
        	System.exit(0);
        }
        for(int i = 1; i < N; i++) { // 맨 왼쪽
        	if(map[i][0] == 1) {
        		block(i, 0);
        	}
        }
        for(int i = 1; i < M - 1; i++) { // 맨 아래
        	if(map[N-1][i] == 1) {
        		block(N - 1, i);
        	}
        }
        
        System.out.println(res);
    }

	private static void block(int y, int x) { // 왼쪽하고 아랫줄 기준 dfs탐색
		map[y][x] = 3;
		for(int i = 0; i < 8; i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx == M - 1 || ny == 0) { // 다음 땅이 맨 위나 맨 오른쪽이면 장애물 1개
				System.out.println(1);
				System.exit(0);
			}
			if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			if(map[ny][nx] == 1) block(ny, nx);
			if(map[ny][nx] == 0) check(ny, nx);
		}
	}

	private static void check(int y, int x) { // 0을 기준으로 2로 넘버링된 장애물이 있나 확인
		map[y][x] = 9;
		for(int i = 0; i < 8; i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] == 3) continue;
			if(map[ny][nx] == 2) { // 2로 넘버링된 장애물이 존재하면 정답은 1
				System.out.println(1);
				System.exit(0);
			}
		}
		
	}

	private static void numbering(int y, int x) { // 윗줄하고 오른쪽 기준 dfs탐색
		map[y][x] = 2;
		if(x == 0 || y == N - 1) { // 맨 오른쪽이나 맨 아래에 도달하면 장애물 필요 없음
			System.out.println(0);
			System.exit(0);
		}
		for(int i = 0; i < 8; i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx == 0 || ny == N - 1) res = 1; // 다음이 맨 오른쪽이나 맨 아래면 일단 장애물 최대 한개
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] != 1) continue;
			numbering(ny, nx);
		}
	}
}