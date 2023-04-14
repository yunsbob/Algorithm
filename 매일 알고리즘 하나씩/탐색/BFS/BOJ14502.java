package study.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {

	static int N, M, result = 0; // 맵 크기, 정답
	static int[][] map; // 맵
	static int[][] mapC; // 맵 복사
	static List<Wall> wallPos = new ArrayList<>(); // 벽을 세울 수 있는 위치
	static List<Virus> virusPos = new ArrayList<>(); // 바이러스가 존재하는 위치
	static Queue<XY> q = new LinkedList<XY>(); // BFS를 위한 큐
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static class Wall{ // 벽을 세울 수 있는 위치
		int x, y;
		public Wall(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Virus{ // 바이러스 존재하는 위치
		int x, y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class XY{
		int x, y;
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BFS() {
		mapC = new int[N][M];
		for(int i = 0; i < N; i++) {
			mapC[i] = map[i].clone();
		}
		XY now; // 현재 위치 담을 객체
		int nx, ny, cnt = 0; // 현재 x,y 그리고 다음 x,y, 안전구역 카운트
		for(Virus v : virusPos) { // 맵에 바이러스 투입
			q.offer(new XY(v.x, v.y));
		}
		while(!q.isEmpty()) { // 바이러스가 가능한 곳 다 채울 때 까지
			now = q.poll();
			for(int i = 0; i < 4; i++) { // 우 하 좌 상 이동
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) { // 맵을 벗어나면 이동하지 않음
					continue;
				}
				if(mapC[ny][nx] == 0) { // 바이러스가 없는 구역이면
					mapC[ny][nx] = 2; // 바이러스 퍼짐
					q.offer(new XY(nx, ny));
				}
			}
		}
		for(Wall w : wallPos) {
			if(mapC[w.y][w.x] == 0) { // 바이러스가 없는 구역이라면 안전구역 카운트
				cnt++;
			}
		}
		result = Math.max(result, cnt); // 안전구역이 더 많다면 정답 입력
	}
	
	
	public static void select(int start, int cnt) {
		if(cnt == 3) { // 벽을 세개 세웠다면
			BFS();
		}
		else { // 아니면 벽 놓을 위치 선택
			for(int i = start; i < wallPos.size(); i++) {
				map[wallPos.get(i).y][wallPos.get(i).x] = 1;
				select(i + 1, cnt + 1);
				map[wallPos.get(i).y][wallPos.get(i).x] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					wallPos.add(new Wall(j, i));
				}
				else if(map[i][j] == 2) {
					virusPos.add(new Virus(j, i));
				}
			}
		}
		
		select(0, 0);
		
		System.out.println(result);
	}
}