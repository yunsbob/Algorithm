package study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] path = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++){
            path[i] = Integer.parseInt(st.nextToken());
        }
        int[] won = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++){
            won[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0, nowon = 1000000000;
        for(int i = 0; i < N - 1; i++){
            nowon = Math.min(nowon, won[i]);
            res += nowon * path[i];
        }

        System.out.println(res);
    }
}