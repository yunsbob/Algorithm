package everyday.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2565 {
	static int N;
	static int[] dp;
	static List<Wire> list = new ArrayList<>();
	
	private static class Wire{
		int a, b;
		
		private Wire(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	list.add(new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        Collections.sort(list, (o1, o2) -> o1.a - o2.a);
        
        int res = 0;
		for(int i = 0; i < N; i++) {
			res = Math.max(res, LIS(i));
		}
		System.out.println(N - res);
	}

	private static int LIS(int cnt) {
		if(dp[cnt] == 0) {
			dp[cnt] = 1;
			for(int i = cnt + 1; i < list.size(); i++) {
				if(list.get(cnt).b < list.get(i).b) {
					dp[cnt] = Math.max(dp[cnt], LIS(i) + 1);
				}
			}
		}
		return dp[cnt];
	}

}
