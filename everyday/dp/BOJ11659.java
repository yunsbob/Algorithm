package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> sum = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        sum.add(0);
        for(int i = 1; i <= N; i++){
            sum.add(Integer.parseInt(st.nextToken()) + sum.get(i - 1));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            sb.append((sum.get(Integer.parseInt(st.nextToken()) - 1) * (-1))+ sum.get(Integer.parseInt(st.nextToken())) + "\n");
        }
        System.out.println(sb);
    }
}
