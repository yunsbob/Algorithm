import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                answer++;
                l++;
                r--;
            } else {
                answer++;
                r--;
            }
        }
        
        return answer;
    }
}