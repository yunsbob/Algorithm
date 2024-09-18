import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        
        for (int n : nums) {
            hs.add(n);
        }
        
        if (hs.size() > nums.length / 2) {
            return nums.length / 2;
        } else {
            return hs.size();
        }
    }
}