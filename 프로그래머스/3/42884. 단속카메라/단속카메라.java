import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int[] res = { 1 };
        int[] min = { routes[0][1] };
        
        Arrays.stream(routes).skip(1)
            .forEach(r -> {
                if (r[0] > min[0]) {
                    res[0]++;
                    min[0] = r[1];
                }
            }
        );

        
        return res[0];
    }
}