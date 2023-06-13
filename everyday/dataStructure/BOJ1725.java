package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1725 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        int[] arr = new int[N+2];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        for (int i = 1; i < N + 2; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                int t = stack.pollLast();
                res = Math.max(res, arr[t] * (i - stack.peekLast() - 1));
            }
            stack.add(i);
        }

        System.out.println(res);
    }
}
