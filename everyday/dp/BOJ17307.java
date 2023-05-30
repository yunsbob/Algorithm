package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17307 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        long[] cntR = new long[N + 1];
        long[] cntL = new long[N + 1];
        long[] res = new long[N + 1];
        int btn = -1;
        long cnt = Long.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 2; i <= N; i++) {
            cntR[i] = cntR[i - 1] + (arr[i] + C - arr[i - 1]) % C;
        }
        for(int i = N - 1; i >= 1; i--) {
            cntL[i] = cntL[i + 1] + (arr[i] + C - arr[i + 1]) % C;
        }

        for(int i = 1; i <= N; i++) {
            res[i] = Math.max(cntL[1] - cntL[i], cntR[N] - cntR[i]);
            if(cnt > res[i]) {
                cnt = res[i];
                btn = i;
            }
        }
        System.out.println(btn);
        System.out.println(cnt);
    }
}