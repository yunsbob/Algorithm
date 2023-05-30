package everyday.bfs;

import java.io.*;
import java.util.*;

public class BOJ16953 {
    static int cnt;
    static long B;
    static Queue<Long> q = new LinkedList<>();

    public static int BFS(){
        long m;
        int size;
        while(!q.isEmpty()){
            size = q.size();
            for(int i = 0; i < size; i++){
                m = q.poll();
                if(m * 2 == B || m * 10 + 1 == B){
                    return ++cnt;
                }
                if(m * 2 <= B){
                    q.add(m*2);
                }
                if(m * 10 + 1 <= B){
                    q.add(m * 10 + 1);
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        cnt = 1;

        q.add(A);
        sb.append(BFS());
        System.out.println(sb);
    }
}
