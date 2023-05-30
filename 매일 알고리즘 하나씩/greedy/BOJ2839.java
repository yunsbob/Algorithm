package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while(N > 0){
            if(N % 5 == 0){ // 1순위 5kg 봉지로 나눠질때
                result += N / 5;
                N = 0;
            }
            else{ // 2순위 안된다면 3kg 봉지 한개로
                N -= 3;
                result++;
            }
        }

        if(N != 0){ // 정확하게 나눠지지 않았다면
            result = -1;
        }

        sb.append(result);
        System.out.println(result);
    }
}