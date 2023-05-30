package everyday.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ16724{
	static int N, M, res = 0;
    static char[][] map;
    static int[] parents;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for(int i = 0; i < N; i++) {
        	String str = br.readLine();
        	map[i] = str.toCharArray();
        }
        
        makeSet();
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		union(i * M + j, next(j, i));
        	}
        }
        
        HashSet<Integer> res = new HashSet<>();
        for(int i = 0; i < N * M; i++) {
        	res.add(find(i));
        }
        
        System.out.println(res.size());
    }

	private static void makeSet() {
		parents = new int[N*M];
		for(int i = 0; i < N * M; i++) {
			parents[i] = i;
		}
	}

	private static int next(int x, int y) {
		if(map[y][x] == 'L') {		
			return y * M + x - 1;
		}
		else if(map[y][x] == 'R') {
			return y * M + x + 1;
		}
		else if(map[y][x] == 'U') {
			return (y - 1) * M + x;
		}
		else {
			return (y + 1) * M + x;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		parents[b] = a;
	}
}