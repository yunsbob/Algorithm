package everyday.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5557 {
	static int N;
	static int[] arr;
	static long[] dp = new long[21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int find = Integer.parseInt(st.nextToken());
		
		dp[arr[0]]++;
		sum(1);
		
		System.out.println(dp[find]);
	}

	private static void sum(int idx) {
		if(idx == N - 1) return;
		else {
			long[] tmp = new long[21];
			for(int i = 0; i <= 20; i++) {
				if(dp[i] != 0) {
					if(i - arr[idx] >= 0) tmp[i - arr[idx]] += dp[i];
					if(i + arr[idx] <= 20) tmp[i + arr[idx]] += dp[i];
				}
			}
			dp = tmp.clone();
			sum(idx + 1);
		}
	}
}
