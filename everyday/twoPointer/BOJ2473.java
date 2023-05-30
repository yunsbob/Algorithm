package everyday.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long[] res = new long[3];
        A: for(int i = 0; i < N - 2; i++) {
        	int s = i + 1, e = N - 1;
        	while(s < e) {
        		if(Math.abs(arr[s] + arr[e] + arr[i]) < min) {
        			min = Math.abs(arr[s] + arr[e] + arr[i]);
        			res[0] = arr[i];
        			res[1] = arr[s];
        			res[2] = arr[e];
        			if(min == 0) break A;
        		}
        		if(arr[s] + arr[e] + arr[i] > 0) e--;
        		else if(arr[s] + arr[e] + arr[i] < 0) s++;
        	}
        }
        sb.append(res[0]).append(' ').append(res[1]).append(' ').append(res[2]);
        System.out.println(sb);
    }
}