import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
            list.clear();
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer.add(list.get(commands[i][2] - 1));
        }
        
        return answer;
    }
}