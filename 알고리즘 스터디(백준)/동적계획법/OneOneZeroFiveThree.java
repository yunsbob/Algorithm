import java.io.*;
import java.util.StringTokenizer;

public class OneOneZeroFiveThree {
    static int[] dp, A;
    
    public static int width(int index, int num){
        if(index == 0){
            if(A[index] < num){
                return dp[index];
            }
            return 0;
        }
        if(A[index] < num){
            return Math.max(width(index-1, num), dp[index]);
        }
        return width(index-1, num);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        A = new int[N];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = width(i, A[i]) + 1;
            if(result < dp[i]){
                result = dp[i];
            }
        }
        sb.append(result);
        System.out.println(sb);
    }
}
