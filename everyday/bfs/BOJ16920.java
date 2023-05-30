package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16920 {
    private static int N, M, P;
    private static char[][] map;
    private static final int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[] move;
    private static int[] res;
    private static Queue<XY>[] q;

    private static class XY{ // 좌표 저장
        int cnt, x, y;

        private XY(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        move = new int[P + 1];
        res = new int[P + 1];
        q = new Queue[P + 1];

        for(int i = 1; i <= P; i++){
            q[i] = new ArrayDeque<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= P; i++){
            move[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j);
                if('1' <= map[i][j] && map[i][j] <= '9'){ // 해당칸이 player 성이라면
                    res[map[i][j] - '0']++; // 해당 성 카운트
                    q[map[i][j] - '0'].offer(new XY(i, j, 0));
                }
            }
        }

        BFS();

        for(int i = 1; i <= P; i++){
            sb.append(res[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void BFS(){
        int turn = 1; // 몇번 플레이어 차례인지
        while (true){
            int size = q[turn].size();
            for(int i = 0; i < move[turn]; i++){ // 이동 가능한만큼 반복
                if(size == 0) break; // 큐에 값이 없다면 종료
                while(size-- > 0){ // 큐에 같은 레벨의 객체수만큼 반복
                    XY now = q[turn].poll();
                    for(int j = 0; j < 4; j++){
                        int nx = now.x + dr[j][0];
                        int ny = now.y + dr[j][1];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != '.') continue;
                        map[nx][ny] = map[now.x][now.y];
                        res[turn]++;
                        if(now.cnt + 1 == move[turn]) // 더 이상 이동 불가능하면
                            q[turn].offer(new XY(nx, ny, 0));
                        else
                            q[turn].offer(new XY(nx, ny, now.cnt + 1));
                    }
                }
                size = q[turn].size();
            }
            turn = turn < P ? turn + 1 : 1;
            if(turn == 1){ // 1번 차례로 돌아왔을때 큐에 값이 없다면 종료
                for (int i = 1; i <= P; i++) {
                    if(!q[i].isEmpty()) break;
                    if(i == P) return;
                }
            }
        }
    }
}
