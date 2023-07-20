package everyday.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ23032 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        int E = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int sum = prefix[j] - prefix[i - 1];
                int left = i, right = j;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (prefix[mid] - prefix[i - 1] >= sum / 2) right = mid;
                    else left = mid + 1;
                }

                if (left < j) {
                    int n = prefix[left] - prefix[i - 1];
                    int m = prefix[j] - prefix[left];
                    int dif = Math.abs(n - m);
                    if (E > dif) {
                        E = dif;
                        res = sum;
                    }
                    else if (E == dif) res = Math.max(res, sum);
                }

                left--;
                if (left >= i) {
                    int n = prefix[left] - prefix[i - 1];
                    int m = prefix[j] - prefix[left];
                    int dif = Math.abs(n - m);
                    if (E > dif) {
                        E = dif;
                        res = sum;
                    }
                    else if (E == dif) res = Math.max(res, sum);
                }
            }
        }

        System.out.println(res);
    }

}