package everyday.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14003{
	static int[] num, A;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        num = new int[N];
        List<Integer> list = new ArrayList<>();
        
        int min, max, mid;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(i == 0) {
            	list.add(A[i]);
            }
            if(A[i] > list.get(list.size() - 1)) {
            	list.add(A[i]);
            	num[i] = list.size() - 1;
            }
            else {
            	min = 0;
            	max = list.size();
            	
            	while(min < max) {
            		mid = (min + max) / 2;
            		if(list.get(mid) >= A[i]) {
            			max = mid;
            		}
            		else {
            			min = mid + 1;
            		}
            	}
            	list.set(max, A[i]);
            	num[i] = max;
            }

        }
        sb.append(list.size()).append('\n');
        num(N - 1, list.size() - 1);
        
        System.out.println(sb);
    }
    
	private static void num(int idx, int result) {
		if(result == -1) return;
		if(num[idx] == result) {
			num(idx - 1, result - 1);
			sb.append(A[idx]).append(' ');
		}
		else {
			num(idx - 1, result);
		}
	}
}