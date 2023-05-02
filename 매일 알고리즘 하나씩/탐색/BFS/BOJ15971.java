import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15971 {
    static int N;
    static List<List<Room>> edge = new ArrayList<>();

    static class Room{
        int num, cost, max;

        private Room(int num, int cost, int max) {
            this.num = num;
            this.cost = cost;
            this.max = max;
        }

        private Room(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            edge.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edge.get(n).add(new Room(m, c));
            edge.get(m).add(new Room(n, c));
        }

        System.out.println(BFS(p1, p2));
    }

    private static int BFS(int p1, int p2) {
        boolean[] check = new boolean[N+1];
        Queue<Room> q = new ArrayDeque<>();

        q.offer(new Room(p1, 0, 0));
        check[p1] = true;

        while(!q.isEmpty()) {
            Room now = q.poll();

            if(now.num == p2) return now.cost - now.max;
            for(Room next : edge.get(now.num)) {
                if(check[next.num]) continue;
                check[next.num] = true;
                q.offer(new Room(next.num, now.cost + next.cost, Math.max(next.cost, now.max)));
            }
        }

        return 0;
    }
}