package everyday.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18185 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int res = 0, now;
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N - 1; i >= 0; i--) {
			if(i > 1 && arr[i - 1] > arr[i - 2]) {
				now = Math.min(arr[i], arr[i - 1] - arr[i - 2]);
				res += now * 5;
				for(int j = i; j > i - 2; j--) {
					arr[j] -= now;
				}
				now = Math.min(arr[i], Math.min(arr[i - 1], arr[i - 2]));
				res += now * 7;
				for(int j = i; j > i - 3; j--) {
					arr[j] -= now;
				}
			}
			else if(i > 1) {
				now = Math.min(arr[i], Math.min(arr[i - 1], arr[i - 2]));
				res += now * 7;
				for(int j = i; j > i - 3; j--) {
					arr[j] -= now;
				}
				now = Math.min(arr[i], arr[i - 1]);
				res += now * 5;
				for(int j = i; j > i - 2; j--) {
					arr[j] -= now;
				}
			}
			else if(i == 1) {
				now = Math.min(arr[i], arr[i - 1]);
				res += now * 5;
				for(int j = i; j > i - 2; j--) {
					arr[j] -= now;
				}
			}
			res += arr[i] * 3;
		}
		System.out.println(res);
	}
}