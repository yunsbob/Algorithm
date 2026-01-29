import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        
        q.add(arr[0]);
        for (int i = 1; i < arr.length; i++){
            if (q.peekLast() != arr[i]) {
                q.add(arr[i]);
            }
        }
        
        while (!q.isEmpty()) {
            res.add(q.poll());
        }

        return res;
    }
}