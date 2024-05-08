class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a > b) {
            for (; b <= a; b++) {
                answer += b;
            }
        } else {
            for (; a <= b; a++) {
                answer += a;
            }
        }
        
        return answer;
    }
}