package everyday.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1958 {
	static Integer[][][] dp;
	static char[] A, B, C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        C = br.readLine().toCharArray();
        
        dp = new Integer[A.length][B.length][C.length];
        
        System.out.println(LCS(A.length - 1, B.length - 1, C.length - 1));
    }

	private static int LCS(int idxA, int idxB, int idxC) {
		if(idxA == -1 || idxB == -1 || idxC == -1) return 0;
		else if(dp[idxA][idxB][idxC] != null) return dp[idxA][idxB][idxC];
		else if(A[idxA] == B[idxB] && A[idxA] == C[idxC] && B[idxB] == C[idxC]) {
			return dp[idxA][idxB][idxC] = LCS(idxA - 1, idxB - 1, idxC - 1) + 1;
		}
		else {
			return dp[idxA][idxB][idxC] = Math.max(LCS(idxA - 1, idxB, idxC), Math.max(LCS(idxA, idxB - 1, idxC), LCS(idxA, idxB, idxC - 1)));
		}
	}
}