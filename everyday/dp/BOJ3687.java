package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3687 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] max = new String[101];
        long[] min = new long[101];

        Arrays.fill(min, Long.MAX_VALUE);
        long[] num = {1, 7, 4, 2, 6, 8, 10}; // 2 ~ 8까지 숫자
        for(int i = 2; i <= 8; i++){
            min[i] = num[i-2];
        }

        int[] addNum = {1, 7, 4, 2, 0, 8}; // 2개 ~ 7개 최소 숫자
        for(int i = 9; i <= 100; i++){
            for(int j = 2; j <= 7; j++){
                min[i] = Math.min(Long.parseLong(min[i-j] + "" + addNum[j-2]), min[i]);
            }
        }

        max[0] = max[1] = "";
        for(int i = 2; i <= 100; i++){ // 짝수일땐 1 추가 홀수일땐 맨앞 7로 변경
            if(i % 2 == 0) max[i] = max[i-2] + 1;
            else max[i] = 7 + max[i-3];
        }

        for(int i = 0; i < N; i++){
            int idx = Integer.parseInt(br.readLine());
            sb.append(min[idx]).append(' ').append(max[idx]).append('\n');
        }

        System.out.println(sb);
    }
}
