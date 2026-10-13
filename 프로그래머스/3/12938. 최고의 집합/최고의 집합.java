class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if (n > s) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }
        
        for (int i = 0; i < s % n; i++) {
            answer[n - 1 - i]++;
        }
        
        return answer;
    }
}