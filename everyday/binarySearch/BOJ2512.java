package everyday.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int min = 0, max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());

        while(min <= max){
            int mid = (min + max) / 2;
            int won = 0;

            for (int i = 0; i < N; i++) {
                if(arr[i] > mid) won += mid;
                else won += arr[i];
            }
            if(won <= M) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(max);
    }
}
