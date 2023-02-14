import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ1504 {
    static int N, E, V1, V2;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    
    static class Node{
        int v;
        int w;
    
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    
    }
    public static int dijkstra(int start, int end) {
    	PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.w, o2.w));
    	pq.offer(new Node(start, 0));
    	Node now;
        Arrays.fill(dist, 600000000);
        dist[start] = 0;
    	while(!pq.isEmpty()) {
    		now = pq.poll();

    		for(Node next : list.get(now.v)) {
    			if(dist[next.v] > dist[now.v] + next.w) {
    				dist[next.v] = now.w + next.w;
    				pq.offer(new Node(next.v, dist[next.v]));
    			}
    		}
    	}
    	return dist[end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[N + 1];
        int a, b, c;

        for(int i = 0; i <= N; i++) {
        	list.add(new ArrayList<Node>());
        }
        
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	c = Integer.parseInt(st.nextToken());
        	
        	list.get(a).add(new Node(b, c));
        	list.get(b).add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        int result1 = 0, result2 = 0 , result;
        
        result1 += dijkstra(1, V1);
        result1 += dijkstra(V1, V2);
        result1 += dijkstra(V2, N);
        
        result2 += dijkstra(1, V2);
        result2 += dijkstra(V2, V1);
        result2 += dijkstra(V1, N);

        result = Math.min(result1, result2);
        
        if(result >= 600000000) {
        	sb.append(-1);
        }
        else {
        	sb.append(result);
        }
        System.out.println(sb);
    }

}