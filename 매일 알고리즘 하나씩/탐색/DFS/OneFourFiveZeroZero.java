import java.io.*;
import java.util.*;

public class OneFourFiveZeroZero {
	static int[] dx = {1, 0, -1};
	static int[] dy = {0, 1, 0};
	static int[][] paper;
	static boolean[][] visited;
	static int N, M, result = 0;
	
	public static boolean check(int cnt, int score) {
		if(cnt == 3) {
			if(result < score) {
				result = score;
			}
			return true;
		}
		return false;
	}
	
	public static void strange(int y, int x, int score, boolean xCheck, boolean yCheck) {
		if(xCheck) {
			if(y - 1 >= 0) {
				if(result < score + paper[y-1][x-1]) {
					result = score + paper[y-1][x-1];
				}
			}
			if(y + 1 < N) {
				if(result < score + paper[y+1][x-1]) {
					result = score + paper[y+1][x-1];
				}
			}
		}
		else {
			if(x - 1 >= 0) {
				if(result < score + paper[y-1][x-1]) {
					result = score + paper[y-1][x-1];
				}
			}
			if(x + 1 < M) {
				if(result < score + paper[y-1][x+1]) {
					result = score + paper[y-1][x+1];
				}
			}
		}
	}
	
	public static void DFS(int y, int x, int score, int cnt, int xcnt, int ycnt) {
        int mx, my;
		if(check(cnt, score)) {
            return ;
		}
		if(xcnt == 2) {
            strange(y, x, score, true, false);
		}
		if(ycnt == 2) {
            strange(y, x, score, false, true);
		}
		for(int i = 0; i < 3; i++) {
            mx = x + dx[i];
			my = y + dy[i];
			if(mx >= 0 && mx < M && my < N && !visited[my][mx]) {
                visited[my][mx] = true;
				if(i == 0) {
					DFS(my, mx, score + paper[my][mx], cnt + 1, xcnt + 1, ycnt);
				}
				else if(i == 1) {
					DFS(my, mx, score + paper[my][mx], cnt + 1, xcnt, ycnt + 1);
				}
				else {
					DFS(my, mx, score + paper[my][mx], cnt + 1, xcnt, ycnt);
				}
				visited[my][mx] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for(int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < M; x++) {
				paper[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < M; x++) {
                visited[y][x] = true;
				DFS(y, x, paper[y][x], 0, 0, 0);
                visited[y][x] = false;
			}
		}

		sb.append(result);
		System.out.println(sb);
	}
}