package everyday.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10282 {
    private static int N;
    private static int[] dist;
    private static List<List<Computer>> list;

    private static class Computer implements Comparable<Computer>{
        int num, cnt;
        private Computer(int num, int dep){
            this.num = num;
            this.cnt = dep;
        }

        @Override
        public int compareTo(Computer o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dist = new int[N+1];
            list = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                dist[j] = Integer.MAX_VALUE;
                list.add(new ArrayList<>());
            }

            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new Computer(a, s));
            }

            Computer res = dijkstra(c);
            sb.append(res.num).append(' ').append(res.cnt).append('\n');
        }
        System.out.println(sb);
    }

    private static Computer dijkstra(int start){
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.offer(new Computer(start, 0));
        dist[start] = 0;
        int cntAll = 0, secAll = 0;

        while (!pq.isEmpty()) {
            Computer now = pq.poll();

            if(dist[now.num] < now.cnt) continue;
            cntAll++;
            secAll = Math.max(secAll, now.cnt);

            for (Computer c: list.get(now.num)) {
                if (dist[c.num] > dist[now.num] + c.cnt) {
                    dist[c.num] = dist[now.num] + c.cnt;
                    pq.offer(new Computer(c.num, dist[c.num]));
                }
            }
        }

        return new Computer(cntAll, secAll);
    }
}
