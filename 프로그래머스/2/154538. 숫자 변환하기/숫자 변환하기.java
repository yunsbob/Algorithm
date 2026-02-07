class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        
        for (int i = x + 1; i <= y; i++) {
            dp[i] = 1_000_001;
        }
        
        for (int i = x; i <= y; i++) {
            if (dp[i] == 1_000_001) continue;
            
            if (i * 2 <= y && dp[i] < dp[i * 2]) {
                dp[i * 2] = dp[i] + 1;
            }
            
            if (i * 3 <= y && dp[i] < dp[i * 3]) {
                dp[i * 3] = dp[i] + 1;
            }     
            
            if (i + n <= y && dp[i] < dp[i + n]) {
                dp[i + n] = dp[i] + 1;
            }
        }
        
        return dp[y] == 1_000_001 ? -1 : dp[y];
    }
}