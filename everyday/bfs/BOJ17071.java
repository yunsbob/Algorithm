package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17071 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) System.out.println(0);
        else System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        boolean[][] visited = new boolean[500001][2];
        int t = 1;
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(N);
        visited[N][0] = true;
        while (!q.isEmpty()) {
            K += t;
            if (K > 500000) return -1;

            int turn = q.size();
            while (turn-- > 0) {
                int now = q.poll();

                if (now - 1 >= 0 && !visited[now - 1][t % 2]) {
                    q.offer(now - 1);
                    visited[now - 1][t % 2] = true;
                }
                if (now + 1 <= 500000 && !visited[now + 1][t % 2]) {
                    q.offer(now + 1);
                    visited[now + 1][t % 2] = true;
                }
                if (now * 2 <= 500000 && !visited[now * 2][t % 2]) {
                    q.offer(now * 2);
                    visited[now * 2][t % 2] = true;
                }
            }
            if (visited[K][t % 2]) return t;
            t++;
        }

        return -1;
    }
}
