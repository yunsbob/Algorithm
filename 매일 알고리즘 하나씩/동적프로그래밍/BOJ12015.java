package everyday.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        List<Integer> list = new ArrayList<>();
        
        int min, max, mid;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(i == 0) {
            	list.add(A[i]);
            }
            if(A[i] > list.get(list.size() - 1)) list.add(A[i]);
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
            }
        }
        System.out.println(list.size());
    }
}