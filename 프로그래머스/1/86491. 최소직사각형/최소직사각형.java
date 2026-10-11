class Solution {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                max1 = Math.max(max1, sizes[i][0]);
                max2 = Math.max(max2, sizes[i][1]);
            } else {
                max1 = Math.max(max1, sizes[i][1]);
                max2 = Math.max(max2, sizes[i][0]);
            }
        }
        
        
        
        return max1 * max2;
    }
}