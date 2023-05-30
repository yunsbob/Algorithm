package everyday.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ21610 {
	static int N, M;
	static int[][] map;
	static boolean[][] cloud; // 구름 위치
	static boolean[][] mapC; // 이동한 구름 위치
	
	private static void makeCloud() { // 구름 생성
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) {
					cloud[i][j] = false;
				}
				else if(map[i][j] > 1) {
					map[i][j] -= 2;
					cloud[i][j] = true;
				}
			}
		}
	}
	
	private static void waterCopy() { // 물복사
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) {
					if(i - 1 >= 0 && j - 1 >= 0 && map[i-1][j-1] != 0) {
						map[i][j]++;
					}
					if(i - 1 >= 0 && j + 1 < N && map[i-1][j+1] != 0) {
						map[i][j]++;
					}
					if(i + 1 < N && j - 1 >= 0 && map[i+1][j-1] != 0) {
						map[i][j]++;
					}
					if(i + 1 < N && j + 1 < N && map[i+1][j+1] != 0) {
						map[i][j]++;
					}
				}
			}
		}
	}
	
	private static void rainy() { // 비내림
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) {
					map[i][j]++;
				}
			}
		}
	}
	
	private static void move(int dir, int dist) { // 구름 이동
		for(int i = 0; i < N; i++) {
			Arrays.fill(mapC[i], false);
		}
		int nx, ny;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) {
					nx = j;
					ny = i;
					if(dir == 1) {
						nx = j - dist;
						while(nx < 0) {
							nx += N;
						}
						mapC[ny][nx] = true;
					}
					else if(dir == 2) {
						nx = j - dist;
						ny = i - dist;
						while(nx < 0) {
							nx += N;
						}
						while(ny < 0) {
							ny += N;
						}
						mapC[ny][nx] = true;
					}
					else if(dir == 3) {
						ny = i - dist;
						while(ny < 0) {
							ny += N;
						}
						mapC[ny][nx] = true;
					}
					else if(dir == 4) {
						nx = j + dist;
						ny = i - dist;
						while(nx >= N) {
							nx -= N;
						}
						while(ny < 0) {
							ny += N;
						}
						mapC[ny][nx] = true;
					}
					else if(dir == 5) {
						nx = j + dist;
						while(nx >= N) {
							nx -= N;
						}
						mapC[ny][nx] = true;
					}
					else if(dir == 6) {
						nx = j + dist;
						ny = i + dist;
						while(nx >= N) {
							nx -= N;
						}
						while(ny >= N) {
							ny -= N;
						}
						mapC[ny][nx] = true;
					}
					else if(dir == 7) {
						ny = i + dist;
						while(ny >= N) {
							ny -= N;
						}
						mapC[ny][nx] = true;
					}
					else if(dir == 8) {
						nx = j - dist;
						ny = i + dist;
						while(nx < 0) {
							nx += N;
						}
						while(ny >= N) {
							ny -= N;
						}
						mapC[ny][nx] = true;
					}
				}
			}
		}
		for(int i = 0; i < N; i++) {
			cloud[i] = mapC[i].clone();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cloud = new boolean[N][N];
		mapC = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = true; // 첫 구름위치
		
		for(int i = 0; i < M; i++) { // 마법시전
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			move(dir, dist);
			rainy();
			waterCopy();
			makeCloud();
		}
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
}