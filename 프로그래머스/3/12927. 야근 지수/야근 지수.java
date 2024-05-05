import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        for (int i = 0; i < n; i++) {
            int w = pq.poll();
            w--;
            
            if (w == 0) {
                if (pq.isEmpty()) {
                    break;
                }
            } else {
                pq.offer(w);
            }
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            long w = pq.poll();
            answer += w * w;
        }
        
        return answer;
    }
}