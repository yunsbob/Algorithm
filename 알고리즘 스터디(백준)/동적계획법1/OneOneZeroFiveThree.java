import java.io.*;
import java.util.StringTokenizer;

public class OneOneZeroFiveThree {
    static int[] dp, num;
    static int N, result = 0;
    
    public static int width(int index){
        if(dp[index] != 0){
            return dp[index];
        }
        for(int i = 0; i < index; i++){
            if(num[i] < num[index]){
                dp[index] = Math.max(dp[i], width(i));
            }
        }
        if(result < dp[index]){
            result = dp[index];
        }
        return dp[index];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        num = new int[N];
        dp[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            width(i);
        }
        
        sb.append(result);
        System.out.println(sb);
    }
}
