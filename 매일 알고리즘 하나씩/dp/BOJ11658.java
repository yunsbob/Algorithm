package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11658 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] arr = new long[N + 1][N + 1];

        for(int y = 1; y <= N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= N; x++){
                arr[y][x] += Long.parseLong(st.nextToken()) + arr[y][x-1];
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order == 0){
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                long change = Long.parseLong(st.nextToken());
                long value = arr[y][x] - arr[y][x-1];
                change -= value;
                for(; x <= N; x++){
                    arr[y][x] += change;
                }
            }
            else if(order == 1){
                int y1 = Integer.parseInt(st.nextToken());
                int x1 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                long result = 0;
                for(int y = y1; y <= y2; y++){
                    result += arr[y][x2] - arr[y][x1 - 1];
                }
                sb.append(result + "\n");
            }
        }
        System.out.println(sb);
    }
}
