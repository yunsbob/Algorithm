import java.util.*;

class Solution {
    public List<?> solution(int[] answers) {
        int[] cnt = new int[3];
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % 5]) {
                cnt[0]++;
            }
            if (answers[i] == b[i % 8]) {
                cnt[1]++;
            }
            if (answers[i] == c[i % 10]) {
                cnt[2]++;
            }
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                list.add(i + 1);
            }
        }
        
        return list;
    }
}