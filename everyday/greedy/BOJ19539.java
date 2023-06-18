package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int sum = 0, odd = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            sum += h;
            if (h % 2 == 1) odd++;
        }

        if (sum % 3 != 0 || odd > sum / 3) System.out.println("NO");
        else System.out.println("YES");
    }
}
