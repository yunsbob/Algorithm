package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11003 {
    private static class Num {
        int n, cnt;

        private Num(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Num> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!q.isEmpty() && q.getLast().n >= num) {
                q.pollLast();
            }
            q.offerLast(new Num(num, i));
            while (q.getFirst().cnt <= i - L) {
                q.pollFirst();
            }
            sb.append(q.getFirst().n).append(' ');
        }
        System.out.println(sb);
    }
}