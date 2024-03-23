import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<>();
        for(String s : completion) {
            if (hm.get(s) != null) {
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
        }
        
        for(String s : participant) {
            if(hm.get(s) != null) {
                if(hm.get(s) == 0) {
                    answer = s;
                    break;
                }
                
                hm.put(s, hm.get(s) - 1);
            } else {
                answer = s;
                break;
            }
        }
        
        return answer;
    }
}