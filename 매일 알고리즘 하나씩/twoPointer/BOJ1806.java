package everyday.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int s = 0, e = 0, sum = 0, res = Integer.MAX_VALUE;
        while(e < N) {
        	sum += arr[e++];
        	if(sum >= S) {
        		res = Math.min(res, e - s);
        		s++;
        		e = s + 1;
        		sum = arr[s];
        		if(sum >= S) {
        			res = 1;
        			break;
        		}
        	}
        }
        
        if(res == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(res);

    }
}