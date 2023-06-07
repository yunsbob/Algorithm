package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ25049 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] L = new long[N];
        long[] R = new long[N];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }

        long v = Math.max(arr[0], 0);
        L[0] = v;
        for (int i = 1; i < N - 1; i++) {
            v = Math.max(v + arr[i], arr[i]);
            L[i] = Math.max(L[i - 1], v);
        }

        v = Math.max(arr[N - 1], 0);
        R[N - 1] = v;
        for (int i = N - 2; i > 0; i--) {
            v = Math.max(v + arr[i], arr[i]);
            R[i] = Math.max(R[i + 1], v);
        }

        long max = 0;
        for (int i = 0; i < N - 1; i++) {
            max = Math.max(L[i] + R[i + 1], max);
        }
        System.out.println(max + sum);
    }
}
