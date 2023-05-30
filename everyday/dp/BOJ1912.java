package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    static Integer[] dp;
    static int[] A;
    
    public static int sum(int index, int num){
        if(index == -1){
            return num;
        }
        if(dp[index] != null ){
            return num + dp[index];
        }
        return Math.max(sum(index-1, num + A[index]), num + A[index]);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N];
        A = new int[N];
        int result = -1001;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = sum(i, 0);
            if(result < dp[i]){
                result = dp[i];
            }
        }
        sb.append(result);
        System.out.println(sb);
    }
}