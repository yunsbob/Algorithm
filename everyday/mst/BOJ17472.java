package everyday.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17472 {
	static int N, M, island = 0;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static List<Edge> bridges = new ArrayList<>();
	static int[] parents;
	
	static class Edge{
		int from, to, len;

		Edge(int from, int to, int len) {
			this.from = from;
			this.to = to;
			this.len = len;
		}
	}
	
	static void makeSet() {
		parents = new int[island + 1];
		for(int i = 1; i <= island; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parents[x] == x) return x;
		return parents[x] = findSet(parents[x]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int getMST() {
		makeSet();
		
		Collections.sort(bridges, (o1, o2) -> Integer.compare(o1.len, o2.len));
		
		int cnt = 0;
		int cost = 0;
		
		for(Edge e : bridges) {
			if(e.len > 1) {
				if(union(e.from, e.to)) {
					cnt++;
					cost += e.len;
					if(cnt == island - 1) return cost;
				}
			}
		}
		return -1;
	}
	
	static void makeBridge(int from, int len, int x, int y, boolean status) {
		if(map[y][x] != 0) {
			if(from != map[y][x]) {
				bridges.add(new Edge(from, map[y][x], len));
			}
			return;
		}
		if(status) {
			if(x + 1 < M) {
				makeBridge(from, len + 1, x + 1, y, true);
			}
		}
		else {
			if(y + 1 < N) {
				makeBridge(from, len + 1, x, y + 1, false);
			}
		}
	}
	
	static void numbering(int x, int y, int num) {
		int nx, ny;
		visited[y][x] = true;
		map[y][x] = num;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || 
					map[ny][nx] == 0 || visited[ny][nx]) continue;
			numbering(nx, ny, num);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {				
				if(map[i][j] == 1 && !visited[i][j]) {
					numbering(j, i, num);
					num++;
					island++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {				
				if(map[i][j] > 0) {
					if(j + 1 < M && map[i][j + 1] == 0) {
						makeBridge(map[i][j], 0, j + 1, i, true);
					}
					if(i + 1 < N && map[i + 1][j] == 0) {
						makeBridge(map[i][j], 0, j, i + 1, false);
					}
				}
			}
		}

		System.out.println(getMST());
	}

}
