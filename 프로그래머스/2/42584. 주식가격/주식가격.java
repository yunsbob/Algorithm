import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] res = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				res[stack.peek()] = i - stack.peek();
				stack.pop();
			}
            
			stack.push(i);
        }
        
		while (!stack.isEmpty()) {
			res[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}
        
        return res;
    }
}