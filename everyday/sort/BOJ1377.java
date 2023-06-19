package everyday.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1377 {
    private static class Number implements Comparable<Number>{
        int num, idx;
        private Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Number o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Number[] arr = new Number[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = new Number(num, i + 1);
        }
        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i].idx - i);
        }

        sb.append(max);
        System.out.println(sb);
    }
}
