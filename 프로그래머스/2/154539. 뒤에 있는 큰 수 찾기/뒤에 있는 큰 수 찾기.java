import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int last = numbers.length;
        int[] answer = new int[last];
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.add(0);
        for (int i = 1; i < last; i++) {
            while (!stack.isEmpty() && numbers[stack.peekLast()] < numbers[i]) {
                answer[stack.pollLast()] = numbers[i];
            }
            
            stack.addLast(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}