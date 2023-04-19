package everyday.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1167 {
	static int N, res = 0;
	static List<List<Node>> list = new ArrayList<>();
	
	private static class Node{
		int num, w;
		private Node(int num, int w) {
			this.num = num;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			while(true) {
				int m = Integer.parseInt(st.nextToken());
				if(m == -1) break;
				int w = Integer.parseInt(st.nextToken());
				list.get(n).add(new Node(m, w));
			}
		}
		
		bfs(bfs(1));
		
		System.out.println(res);
	}
	
	private static int bfs(int s) {
		boolean[] visited = new boolean[N + 1];
		
		visited[s] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(s, 0));
		int maxW = 0, maxIdx = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(Node next : list.get(now.num)) {
				if(!visited[next.num]) {
					visited[next.num] = true;
					if(now.w + next.w > maxW) {
						maxW = now.w + next.w;
						maxIdx = next.num;
					}
					q.offer(new Node(next.num, now.w + next.w));
				}
			}
		}
		
		res = Math.max(res, maxW);
		return maxIdx;
	}
}