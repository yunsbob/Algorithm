import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneZeroEightOneSix {
    static long[] arr;
    static int N;
    public static long binarySearch(long left, long right, int N) {
		long mid = 0;
        long cnt = 0;

		if(left < right) {
			mid = (left + right) / 2;

            for(int i = 0; i < arr.length; i++){
                cnt += arr[i] / mid;
            }

			if(cnt < N) {
				return binarySearch(left, mid, N);  
			}
			else { 
				return binarySearch(mid + 1, right, N); 
			}
		}

		return left;
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long max = 0;
        arr = new long[K];

        for(int i = 0; i < K; i++){
            arr[i] = Long.parseLong(br.readLine());
            if(max < arr[i]) {
				max = arr[i];
			}
        }

        sb.append(binarySearch(0, max + 1, N) - 1);
        System.out.println(sb);
    }
}