package everyday.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], 999999999);
		}
		
		int edgeN = Integer.parseInt(br.readLine());
		for(int i = 0; i < edgeN; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(arr[from][to] > e) {
				arr[from][to] = e;
			}
		}
		
		floyd();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(arr[i][j] == 999999999) {
					sb.append(0).append(' ');
				}
				else {
					sb.append(arr[i][j]).append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	private static void floyd() {
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                	if(i == j) arr[i][j] = 0;
                	else if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
	}

}
