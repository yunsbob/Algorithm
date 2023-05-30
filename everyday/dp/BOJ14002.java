package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14002 {
    static int[] dp, A;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        A = new int[N];
        int result = 0, idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = width(i, A[i]) + 1;
            if(result < dp[i]){
            	idx = i;
                result = dp[i];
            }
        }
        sb.append(result).append('\n');
        
        num(idx, result);

        System.out.println(sb);
    }

	private static int width(int index, int num){
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
    
	private static void num(int idx, int result) {
		if(result == 0) return;
		else if(dp[idx] == result) {
			num(idx - 1, result - 1);
			sb.append(A[idx]).append(' ');
		}
		else {
			num(idx - 1, result);
		}
	}
	
}