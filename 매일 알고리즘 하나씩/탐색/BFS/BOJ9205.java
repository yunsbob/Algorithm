package everyday.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9205 {
	static List<XY> town;
	static List<ArrayList<Integer>> move;
	static Queue<Integer> q;
	static boolean[] visited;
	static int N;
	
	private static class XY{
		int x, y;

		private XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	private static boolean BFS() {
		int n;
		while(!q.isEmpty()) {
			n = q.poll();
			if(n == N + 1) {
				return true;
			}
			for(int i = 0; i < move.get(n).size(); i++) {
				if(!visited[move.get(n).get(i)]) {
					visited[move.get(n).get(i)] = true;
					q.add(move.get(n).get(i));
				}
			}
		}
		return false;
	}
	
	private static boolean check(XY now, XY next) {
		if(Math.abs(now.x - next.x) + Math.abs(now.y - next.y) <= 1000) {
			return true;
		}
		return false;
	}
	
	private static void link(int now) {
		if(now == N + 2) {
			return;
		}
		for(int i = now + 1; i < N + 2; i++) {
			if(check(town.get(now), town.get(i))) {
				move.get(now).add(i);
				move.get(i).add(now);
			}
		}
		link(now + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			town = new ArrayList<XY>();
			move = new ArrayList<>();
			visited = new boolean[N+2];
			for(int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				town.add(new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				move.add(new ArrayList<>());
			}
			link(0);
			q = new LinkedList<>();
			q.add(0);
			sb.append(BFS() ? "happy" : "sad").append('\n');
		}
		System.out.println(sb);
	}

}
