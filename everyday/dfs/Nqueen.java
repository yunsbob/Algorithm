package everyday.dfs;

import java.io.*;

public class Nqueen {
    static int[] chess;
    static int N, result = 0;

    public static boolean check(int y){
        for(int y2 = 0; y2 < y; y2++){
            if(chess[y] == chess[y2] || Math.abs(chess[y] - chess[y2]) == (y - y2)){
                return false;
            }
        }
        return true;
    }

    public static void queen(int y){
        if(y == N){
            result++;
        }
        else{
            for(int x = 0; x < N; x++){
                chess[y] = x;
                if(check(y)){
                    queen(y+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        chess = new int[N];

        queen(0);

        sb.append(result);
        System.out.println(sb);
    }
}
