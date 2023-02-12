import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] grapeSoju = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            grapeSoju[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grapeSoju[1];
        
        if(N > 1){
            dp[2] = grapeSoju[1] + grapeSoju[2];
        }

        if(N > 2){
            for(int i = 3; i <= N; i++){
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapeSoju[i], dp[i - 3] + grapeSoju[i - 1] + grapeSoju[i]));
            }
        }

        System.out.println(dp[N]);
    }
}