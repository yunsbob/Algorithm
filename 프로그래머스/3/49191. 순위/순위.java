class Solution {
    public int solution(int n, int[][] results) {
        int[][] match = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
			match[results[i][0]][results[i][1]] = 1;
			match[results[i][1]][results[i][0]] = - 1;
        }

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                
				for (int k = 1; k <= n; k++) {
                    if (i == k || j == k) continue;
                    
					if (match[i][k] == 1 && match[k][j] == 1) {
						match[i][j] = 1;
						match[j][i] = -1;
					}
					
					if (match[i][k] == -1 && match[k][j] == -1) {
						match[i][j] = -1;
						match[j][i] = 1;
					}
				}
			}
		}
		
		int res = 0;
		
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
            
			for (int j = 1; j <= n; j++) {
				if (match[i][j] != 0) cnt++;
			}
            
			if (cnt == n - 1) res++;
		}
        
        return res;
    }
}