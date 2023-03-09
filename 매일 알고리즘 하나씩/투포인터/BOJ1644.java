package everyday.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1644 {
    static int N;
    static ArrayList<Integer> num = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        makePrime();
        
        int s = 0, e = 0, sum = 0, res = 0; 
        while(true) {
            if(sum > N) {
                sum -= num.get(s++);
            }
            else if(sum < N) {
            	if(e == num.size()) break;
            	sum += num.get(e++);
            }
            if(sum == N) {
            	res++;
            	sum -= num.get(s++);
            }
        }
        
        System.out.println(res);
        
    }
    
    static void makePrime() {
        int tmp[] = new int[N+1];

        for(int i = 2; i <= N; i++) {
            tmp[i] = i;
        }
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(tmp[i] != 0 ) {
                for(int j = i * 2; j <= N; j += i) {
                    tmp[j] = 0;
                }
            }
        }
        for(int i = 2; i <= N; i++) {
            if(tmp[i] != 0) {
                num.add(tmp[i]);
            }
        }    
    }
}