package study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2170 {
	private static class SE {
		int start, end;
		private SE(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        SE[] arr = new SE[N]; 
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	arr[i] = new SE(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);
        
        int res = 0, min = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
        	if(max <= arr[i].start) {
        		res += max - min;
        		min = arr[i].start;
        		max = arr[i].end;
        	}
        	else if(max <= arr[i].end) {
        		max = arr[i].end;
        	}
        }
        res += max - min;
        System.out.println(res);
	}
}