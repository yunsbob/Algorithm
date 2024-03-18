class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i -1][j - 1]) + triangle[i][j];
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < size; i++) {
            res = Math.max(res, dp[size - 1][i]);
        }
        
        return res;
    }
}