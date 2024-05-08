class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int i = 3; i < total; i++) {
            int j = total / i;
            
            if (j >= i) {
                if ((i - 2) * (j - 2) == yellow) {
                    int[] answer = {j, i};
                    return answer;
                }
            }
        }
        
        return new int[2];
    }
}