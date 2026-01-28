import java.util.*;

class Solution {
    static ArrayList<String> list;
    static boolean visited[];
    
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        
        String[] answer = new String[tickets.length + 1];
        StringTokenizer st = new StringTokenizer(list.get(0));
        for (int i = 0; i <= tickets.length; i++) {
            answer[i] = st.nextToken();
        }
        
        return answer;
    }
    
    static void dfs(int idx, String now, String path, String[][] tickets){
        if (idx == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}