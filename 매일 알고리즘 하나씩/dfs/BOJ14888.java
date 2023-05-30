package everyday.dfs;

import java.io.*;
import java.util.*;

public class BOJ14888 {
    static int[] arr, pmtm = new int[4];
    static int[] result = new int[2];
    static int N;

    public static boolean check(int index, int num) {
        if(index == N) {
			if(result[0] < num){
                result[0] = num;
            }
            if(result[1] > num){
                result[1] = num;
            }
			return true;
		}
		return false;
	}
	
	public static void DFS(int index, int math) {
        if(check(index, math)) {
            return ;
		}
		
		for(int j = 0; j < 4; j++){
            if(pmtm[j] > 0){
                pmtm[j]--;
                if(j == 0){
                    DFS(index + 1, math + arr[index]);
                }
                else if(j == 1){
                    DFS(index + 1, math - arr[index]);
                }
                else if(j == 2){
                    DFS(index + 1, math * arr[index]);
                }
                else {
                    if(math > 0){
                        DFS(index + 1, math / arr[index]);
                    }
                    else{
                        DFS(index + 1, math * -1 / arr[index] * -1);
                    }
                }
                pmtm[j]++;
            }
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
		
        st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++){
            pmtm[i] = Integer.parseInt(st.nextToken());
        }
		
		DFS(1, arr[0]);

        sb.append(result[0] + "\n" + result[1]);
		
		System.out.println(sb);
	}
}
