package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573 {
    private static int N, M;
    private static int[][] map;
    private static int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static Queue<XY> q = new ArrayDeque<>();
    private static class XY {
        int x, y;

        private XY (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    q.offer(new XY(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int res = 0;

        while (true) {
            if (q.size() == 0) {
                res = 0;
                break;
            }

            boolean[][] visited = new boolean[N][M];
            int cnt = 0;
            XY now = q.poll();
            q.offer(now);
            Queue<XY> bfsQ = new ArrayDeque();
            bfsQ.offer(now);
            visited[now.x][now.y] = true;

            while (!bfsQ.isEmpty()) {
                now = bfsQ.poll();
                cnt++;
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dr[i][0];
                    int ny = now.y + dr[i][1];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M
                            || map[nx][ny] <= 0 || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    bfsQ.offer(new XY(nx, ny));
                }
            }

            if (cnt != q.size()) break;
            melt();

            res++;
        }
        return res;
    }

    private static void melt() {
        int size = q.size();
        boolean[][] visited = new boolean[N][M];

        while (size-- > 0) {
            XY now = q.poll();
            visited[now.x][now.y] = true;
            int mel = 0;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dr[i][0];
                int ny = now.y + dr[i][1];
                if(map[nx][ny] > 0 || visited[nx][ny]) continue;
                mel++;
            }
            map[now.x][now.y] -= mel;

            if (map[now.x][now.y] > 0) {
                q.offer(now);
            }
        }
    }
}