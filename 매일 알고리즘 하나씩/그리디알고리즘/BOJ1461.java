package study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pqPlus = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > 0) pqPlus.offer(num);
            else pqMinus.offer(num);
        }

        int res = 0;
        if(pqPlus.isEmpty()){
            res += Math.abs(pqMinus.peek());
            for(int i = 0; i < M; i++){
                pqMinus.poll();
                if(pqMinus.isEmpty()) break;
            }
        }
        else if(pqMinus.isEmpty()){
            res += pqPlus.peek();
            for(int i = 0; i < M; i++){
                pqPlus.poll();
                if(pqPlus.isEmpty()) break;
            }
        }
        else if(Math.abs(pqMinus.peek()) > Math.abs(pqPlus.peek())) {
            res += Math.abs(pqMinus.peek());
            for(int i = 0; i < M; i++){
                pqMinus.poll();
                if(pqMinus.isEmpty()) break;
            }
        }
        else {
            res += pqPlus.peek();
            for(int i = 0; i < M; i++){
                pqPlus.poll();
                if(pqPlus.isEmpty()) break;
            }
        }

        while(!pqPlus.isEmpty()){
            res += pqPlus.poll() * 2;
            for(int i = 1; i < M; i++){
                pqPlus.poll();
                if(pqPlus.isEmpty()) break;
            }
        }
        while(!pqMinus.isEmpty()){
            res += Math.abs(pqMinus.poll()) * 2;
            for(int i = 1; i < M; i++){
                pqMinus.poll();
                if(pqMinus.isEmpty()) break;
            }
        }

        System.out.println(res);
    }
}
