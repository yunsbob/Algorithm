package everyday.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1090 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] pos = new int[N][2];
        int[] res = new int[N];
        int[] dis = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
            res[i] = 100000000;
        }

        res[0] = 0; // 1개의 체커가 모이려면 0번 이동
        for (int i = 1; i < N; i++) { // i + 1개의 체커가 움직임
            for (int j = 0; j < N; j++) { // x 좌표를 j로 지정
                for (int k = 0; k < N; k++) { // y 좌표를 k로 지정
                    int tmp = 0;
                    for (int l = 0; l < N; l++) { // j, k와 l번째 체커의 좌표 거리 계산
                        dis[l] = Math.abs(pos[j][0] - pos[l][0]) + Math.abs(pos[k][1] - pos[l][1]);
                    }

                    Arrays.sort(dis);
                    for (int l = 0; l <= i; l++) { // i + 1개만큼 가장 적은 거리순으로 더해줌
                        tmp += dis[l];
                    }

                    res[i] = Math.min(res[i], tmp); // 값 비교
                }
            }
        }

        for (int n: res) {
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }
}
