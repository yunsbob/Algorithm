package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ12852 {
	static Cnt now;
	static StringBuilder sb = new StringBuilder();
	
	static class Cnt{
		int num, cnt;
		Cnt prev;
		private Cnt(int num, int cnt, Cnt prev) {
			this.num = num;
			this.cnt = cnt;
			this.prev = prev;
		}
	}
	
	private static void print(Cnt now) {
		if(now.prev != null) {
			print(now.prev);
		}
		sb.append(now.num).append(' ');
	}

	private static void BFS(int n) {
		Queue<Cnt> q = new ArrayDeque<>();
		boolean[] check = new boolean[n+1];
		q.offer(new Cnt(n, 0, null));
		while(!q.isEmpty()) {
			now = q.poll();
			if(now.num == 1) {
				return;
			}
			if(now.num % 3 == 0 && !check[now.num / 3]) {
				check[now.num / 3] = true;
				q.offer(new Cnt(now.num / 3, now.cnt + 1, now));
			}
			if(now.num % 2 == 0 && !check[now.num / 2]) {
				check[now.num / 2] = true;
				q.offer(new Cnt(now.num / 2, now.cnt + 1, now));
			}
			if(!check[now.num - 1]) {
				q.offer(new Cnt(now.num - 1, now.cnt + 1, now));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		BFS(N);
		sb.append(now.cnt).append('\n');
		
		print(now);
		
		System.out.println(sb);
	}
}