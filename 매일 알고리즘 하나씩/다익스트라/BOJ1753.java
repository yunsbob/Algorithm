import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ1753 {
    static int V, E;
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
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.w, o2.w));
        boolean[] check = new boolean[V + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.v;

            if (!check[now]) {
                check[now] = true;

                for (Node next : list.get(now)) {
                    if (!check[next.v] && dist[next.v] > dist[now] + next.w) {
                        dist[next.v] = dist[now] + next.w;
                        pq.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        dijkstra(start);
        for(int i = 1; i <= V; i++) {
        	if(dist[i] == Integer.MAX_VALUE) {
        		sb.append("INF").append('\n');
        	}
        	else {
        		sb.append(dist[i]).append('\n');
        	}
        }
        System.out.println(sb);
    }

}