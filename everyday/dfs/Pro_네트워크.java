package everyday.dfs;

public class Pro_네트워크 {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] check = new boolean[n];

            for(int i = 0; i < n; i++){
                if(check[i]) continue;
                answer++;
                dfs(n, i, computers, check);
            }

            return answer;
        }

        public void dfs(int n, int node, int[][] computers, boolean[] check) {
            check[node] = true;
            for(int i = 0; i < n; i++){
                if(check[i] || i == node || computers[node][i] == 0) continue;
                dfs(n, i, computers, check);
            }
        }
}
