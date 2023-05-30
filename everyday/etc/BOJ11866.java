package everyday.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ11866 {
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<Integer>();
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i = 0; i < N; i++){
            q.add(i+1);
        }
        
        sb.append("<");
        
        while(N > 1){
            cnt++;
            int num = q.poll();
            if(cnt == K){
                sb.append(num + ", ");
                N--;
                cnt = 0;
            }
            else{
                q.add(num);
            }
        }
        sb.append(q.poll() + ">");
        System.out.println(sb);
    }
}