import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pollLast();
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}