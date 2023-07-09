package everyday.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1486 {
    private static int N, M, T;
    private static char[][] map;
    private static int[][][][] dist;
    private static int[] height;

    private static class XY {
        int x, y, cnt;

        private XY (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dist = new int[N][M][N][M];

        int D = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < M; l++) {
                        dist[i][j][k][l] = D + 1;
                    }
                }
            }
        }

        height = new int['z' + 1];
        for (int i = 'A'; i <= 'Z'; i++) {
            height[i] = i - 'A';
        }
        for (int i = 'a'; i <= 'z'; i++) {
            height[i] = i - 'a' + 26;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dijkstra(i, j);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[0][0][i][j] + dist[i][j][0][0] <= D) res = Math.max(res, height[map[i][j]]);
            }
        }
        System.out.println(res);
    }

    private static void dijkstra(int sx, int sy) {
        int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        PriorityQueue<XY> q = new PriorityQueue<>(((o1, o2) -> o1.cnt - o2.cnt));
        dist[sx][sy][sx][sy] = 0;
        q.offer(new XY(sx, sy, 0));
        while (!q.isEmpty()) {
            XY now = q.poll();
            if (sx != 0 && sy != 0 && now.x == 0 && now.y == 0) return;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dr[i][0];
                int ny = now.y + dr[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int h = Math.abs(height[map[nx][ny]] - height[map[now.x][now.y]]);
                if (h <= T) {
                    if (height[map[now.x][now.y]] < height[map[nx][ny]]) {
                        int dis = now.cnt + h * h;
                        if (dist[sx][sy][nx][ny] > dis) {
                            q.offer(new XY(nx, ny, dis));
                            dist[sx][sy][nx][ny] = dis;
                        }
                    }
                    else {
                        int dis = now.cnt + 1;
                        if (dist[sx][sy][nx][ny] > dis) {
                            q.offer(new XY(nx, ny, dis));
                            dist[sx][sy][nx][ny] = dis;
                        }
                    }
                }
            }
        }
    }
}