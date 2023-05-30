package everyday.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ2467 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int res1 = 0, res2 = 0, s = 0, e = N - 1, min = Integer.MAX_VALUE;
        while(s < e) {
        	if(Math.abs(arr[s] + arr[e]) < Math.abs(min)) {
        		min = arr[s] + arr[e];
        		res1 = arr[s];
        		res2 = arr[e];
        		if(min == 0) break;
        	}
        	if(arr[s] + arr[e] > 0) e--;
        	else if(arr[s] + arr[e] < 0) s++;
        }
        sb.append(res1).append(' ').append(res2);
        System.out.println(sb);
    }
}