package everyday.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = (int)Math.sqrt(y - x);
            int res = 0;

            if (r == Math.sqrt(y - x)) res = r * 2 - 1;
            else if (y - x <= r * r + r) res = r * 2;
            else res = r * 2 + 1;
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}
