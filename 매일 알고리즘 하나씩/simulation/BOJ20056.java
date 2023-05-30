package everyday.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20056 {
    static int N, M, K;
    static List<Fireball> list = new ArrayList<>();
    static List<Fireball>[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    
    private static class Fireball {
    	int r, c, m, d, s;
    	
    	private Fireball(int r, int c, int m, int d, int s) {
    		this.r = r;
    		this.c = c;
    		this.m = m;
    		this.d = d;
    		this.s = s;
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new List[N][N];
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		map[i][j] = new ArrayList<>();
        	}
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Fireball(r, c, m, d, s));
        }

        for(int i = 0; i < K; i++){
            move();
            combNdiv();
        }

        int res = 0;
        for (Fireball f : list) {
            res += f.m;
        }
        System.out.print(res);
    }

    private static void move() {
        for (Fireball f : list) {
            f.r = (f.r + dy[f.d] * (f.s % N) + N) % N;
            f.c = (f.c + dx[f.d] * (f.s % N) + N) % N;
            map[f.r][f.c].add(f);
        }
    }

    private static void combNdiv() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].size() < 2) {
                	map[i][j].clear();
                }
                else {
                	int m = 0, s = 0, cnt = map[i][j].size();
                	boolean one = true, two = true;
                	
                	while (!map[i][j].isEmpty()) {
                		Fireball f = map[i][j].remove(0);
                		m += f.m;
                		s += f.s;
                		if (f.d % 2 == 0) one = false;
                		else two = false;
                		list.remove(f);
                	}
                	
                	if (m < 5)
                		continue;
                	
                	if(one || two) {
                		for(int d = 0; d < 8; d += 2) {
                			list.add(new Fireball(i, j, m / 5, d, s / cnt));
                		}
                	}
                	else {
                		for (int d = 1; d < 8; d += 2) {
                			list.add(new Fireball(i, j, m / 5, d, s / cnt));
                		}
                	}
                }
            }
        }
    }
}
