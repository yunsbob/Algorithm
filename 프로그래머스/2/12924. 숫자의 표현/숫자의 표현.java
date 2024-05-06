class Solution {
    public int solution(int n) {
        int answer = 0;
        int s = 1;
        int sum = 0;
        
        if (n == 1 || n == 2)
            return 1;
        
        for (int i = 1; i <= n / 2 + 1; i++) {
            sum += i;
            
            while (sum > n) {
                sum -= s;
                s++;
            }
            
            if (sum == n) {
                answer++;
            }
        }
        
        return ++answer;
    }
}