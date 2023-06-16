package everyday.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = N - 1, people = N - 2, res = 0;
        while (l < r) {
            res = Math.max(res, people * Math.min(arr[l], arr[r]));
            people--;
            if (arr[l] < arr[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        System.out.println(res);
    }
}
