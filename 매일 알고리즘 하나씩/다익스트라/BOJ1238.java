package everyday.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
	static int N;
	
	static class Path{
		int next, w;
		
		Path(int next, int w) {
			this.next = next;
			this.w = w;
		}
	}
	
    static void dijkstra(int start, int[] dist, List<List<Path>> list) {
        PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        boolean[] check = new boolean[N + 1];
        pq.offer(new Path(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Path nowNode = pq.poll();
            int now = nowNode.next;

            if (!check[now]) {
                check[now] = true;

                for (Path v : list.get(now)) {
                    if (!check[v.next] && dist[v.next] > dist[now] + v.w) {
                        dist[v.next] = dist[now] + v.w;
                        pq.add(new Path(v.next, dist[v.next]));
                    }
                }
            }
        }
    }
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int res = 0;
        
        List<List<Path>> listX = new ArrayList<>();
        List<List<Path>> listN = new ArrayList<>();
        int[] distX = new int[N + 1];
        int[] distN = new int[N + 1];
        Arrays.fill(distX, Integer.MAX_VALUE);
        Arrays.fill(distN, Integer.MAX_VALUE);
        
        for(int i = 0; i <= N; i++) {
        	listX.add(new ArrayList<>());
        	listN.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	listX.get(end).add(new Path(start, w));
        	listN.get(start).add(new Path(end, w));
        }
        
        dijkstra(X, distX, listX);
        dijkstra(X, distN, listN);
        
        for(int i = 1; i <= N; i++) {
        	int xn = distX[i] + distN[i];
        	res = Math.max(res, xn);
        }
        System.out.println(res);
	}
}
