import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneEightOneOneOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int min = 256;
        int max = 0;
        int resultS = -1;
        int resultH = -1;

        for (int i = 0; i < ground.length; i++) { // 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                ground[i][j] = height;
                if(max < height){
                    max = height;
                }
                if(min > height){
                    min = height;
                }
            }
        }

        for (int i = min; i <= max; i++) { // i : 목표 땅 높이
            int s = 0;
            int b = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int block = ground[j][k] - i;
                    if(block > 0) { // 목표 땅 높이보다 높을때는 땅을 팜 2초
                        s += block * 2;
                        b += block;
                    }
                    else if(block < 0){ // 목표 땅 높이보다 낮을때는 블록을 추가함 1초
                        s += block * -1;
                        b -= block * -1;
                    }
                }
            }
            if(b >= 0) { // 인벤토리에 블록이 없다면 i 높이만큼 땅고르기는 불가능함
                if(s <= resultS || resultS == -1) { // -1이면 아직 시간에 대한 결과값이 없는 상태
                    resultS = s;
                    resultH = i;
                }
            }
        }

        sb.append(resultS + " " + resultH);
        System.out.println(sb);
    }
}
