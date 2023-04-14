import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {
    static boolean[][] visited, farm;
    static int N, M;
    static int[] dx = {1, 0, -1, 0}; // x 이동
    static int[] dy = {0, 1, 0, -1}; // y 이동
    static Queue<XY> q = new LinkedList<>();
    static XY now;

    public static class XY { // xy 좌표를 담는 객체
        int x, y;

        public XY(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int y, int x){
        int nX, nY;
        visited[y][x] = true;
        q.offer(new XY(x, y));
        while(!q.isEmpty()){
            now = q.poll(); // 현재 위치 방문
            for(int i = 0; i < 4; i++){
                nX = now.x + dx[i]; // 다음에 이동할 x 입력
                nY = now.y + dy[i]; // 다음에 이동할 y 입력
                if(nX < 0 || nY < 0 || nX >= M || nY >= N){ // 맵에서 벗어날 때
                    continue;
                }
                if(!visited[nY][nX] && farm[nY][nX]){ // 방문한적 없고 배추가 있을때
                    visited[nY][nX] = true; // 방문처리
                    q.offer(new XY(nX, nY)); // 좌표 입력
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){ // 테스트 케이스
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            farm = new boolean[N][M];
            visited = new boolean[N][M];
            int K = Integer.parseInt(st.nextToken());

            for(int i = 0; i < K; i++){ // 배추 심기
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = true;
            }
            
            int result = 0;
            for(int y = 0; y < N; y++){
                for(int x = 0; x < M; x++){ // 방문한적 없는 곳에 배추가 있다면
                    if(!visited[y][x] && farm[y][x]){
                        result++; // 배추흰지렁이 추가
                        BFS(y, x);
                    }
                }
            }
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}