package everyday.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N + 1];

        for (int i = 0; i < B; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= K; i++) {
            if (arr[i]) cnt++;
        }

        int res = cnt;
        for (int i = K + 1; i <= N; i++) {
            if (arr[i]) cnt++;
            if (arr[i - K]) {
                cnt--;
                res = Math.min(res, cnt);
            }
        }

        System.out.println(res);
    }
}
