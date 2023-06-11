package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10974 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0, 0);

        System.out.println(sb);
    }

    private static void dfs(int idx, int flag){
        if(idx == arr.length){
            for(int n : arr){
                sb.append(n).append(' ');
            }
            sb.append('\n');
        }
        else{
            for (int i = 0; i < arr.length; i++) {
                if((flag & 1 << i) != 0) continue;
                arr[idx] = i + 1;
                dfs(idx + 1, flag | 1 << i);
            }
        }
    }
}
