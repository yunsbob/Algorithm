package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    private static int N;
    private static int[] arr;
    private static int[] choice = new int[6];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, int start) {
        if (idx == 6) {
            for (int num : choice) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
        }
        else {
            for (int i = start; i < N; i++) {
                choice[idx] = arr[i];
                dfs(idx + 1, i + 1);
            }
        }
    }
}
