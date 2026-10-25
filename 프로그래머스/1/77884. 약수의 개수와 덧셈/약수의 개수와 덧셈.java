class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            int flag = 0;
            
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    flag++;
                }
            }
            
            if (flag % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}