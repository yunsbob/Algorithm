package everyday.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int res = 0, now = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) {
                now++;
                res = Math.max(res, now);
            }
            else {
                now--;
                if (now == -1) now = 0;
            }
        }

        now = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 2) {
                now++;
                res = Math.max(res, now);
            }
            else {
                now--;
                if (now == -1) now = 0;
            }
        }
        System.out.println(res);
    }
}
