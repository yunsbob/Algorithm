import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> pqB = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (int i = 0; i < A.length; i++) {
            pqA.offer(A[i]);
            pqB.offer(B[i]);
        }
        
        while(!pqA.isEmpty()) {
            answer += pqA.poll() * pqB.poll();
        }

        return answer;
    }
}