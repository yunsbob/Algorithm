class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] += calMax(land[i - 1], j);
            }
        }

        return calMax(land[land.length - 1], -1);
    }
    
    int calMax(int[] pl, int j) {
        int max = 0;
        
        for (int i = 0; i < 4; i++) {
            if (i == j)
                continue;
            
            max = Math.max(max, pl[i]);
        }
        
        return max;
    }
}