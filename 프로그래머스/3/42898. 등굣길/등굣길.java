class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] map = new boolean[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = true;
        }
        
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] || (i == 1 && j == 1)) continue;
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_007;
            }
        }
        
        return dp[n][m];
    }
}