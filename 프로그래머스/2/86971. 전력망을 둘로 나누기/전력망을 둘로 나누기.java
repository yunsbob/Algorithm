class Solution {
    static int len;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = n;

        len = n - 1;

        for (int cut = 0; cut < len; cut++) {
            visited = new boolean[n + 1];

            int cnt = dfs(1, cut, wires);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public int dfs(int now, int cut, int[][] wires) {
        visited[now] = true;
        int cnt = 1;

        for (int i = 0; i < len; i++) {
            if (i == cut) continue;

            int a = wires[i][0];
            int b = wires[i][1];

            if (now == a && !visited[b]) {
                cnt += dfs(b, cut, wires);
            } else if (now == b && !visited[a]) {
                cnt += dfs(a, cut, wires);
            }
        }

        return cnt;
    }
}