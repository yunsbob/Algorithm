import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> list; // 인접리스트.
    static int[] dist; // 최소 비용
    
    static class Node{ // 다음 노드와 그 간선의 가중치
        int end;
        int cost;
    
        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    
    }
    public static int dijkstra(int start, int end) {
        // 최소 가중치부터 방문하기 위해
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        boolean[] check = new boolean[N + 1]; // 방문 확인 배열
        pq.offer(new Node(start, 0)); // 시작지점은 가중치 0
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.end; // 현재 노드

            if (!check[now]) { // 방문한적 없다면 방문
                check[now] = true;

                for (Node next : list.get(now)) { // 연결된 모든 노드
                    // 방문한적 없고 현재 노드에서 다음 노드로 갔을때 최소비용이 더 적다면
                    if (!check[next.end] && dist[next.end] > dist[now] + next.cost) {
                        dist[next.end] = dist[now] + next.cost; // 다음 노드 최소 비용 변경
                        pq.add(new Node(next.end, dist[next.end])); // 방문할 노드와 비용 입력
                    }
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE); // 비용 비교를 위해 max로 채움

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // start에서 end로 가는 cost
            list.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startPos, endPos));
    }

}