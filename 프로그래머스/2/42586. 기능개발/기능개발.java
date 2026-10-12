import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else {
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        
        int day = 1;
        while (!q.isEmpty()) {
            int cnt = 0;
            while (!q.isEmpty() && q.peek() <= day) {
                q.poll();
                cnt++;
            }
            
            if (cnt != 0) {
                answer.add(cnt);
            }
            
            day++;
        }
        
        return answer;
    }
}