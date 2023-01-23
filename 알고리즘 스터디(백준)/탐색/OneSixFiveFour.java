import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneSixFiveFour {
    static long[] arr;
    static int N;
    public static long binarySearch(long left, long right, int N) {
		long mid = 0;
        long cnt = 0;

		if(left < right) {
			mid = (left + right) / 2;

            for(int i = 0; i < arr.length; i++){
                cnt += arr[i] / mid; // 막대기 자르기
            }

			if(cnt < N) { // 막대기 개수가 부족할 경우 더 자름
				return binarySearch(left, mid, N);  
			}
			else { // 막대기 개수가 충분할 경우 길이를 늘림
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

        sb.append(binarySearch(0, max + 1, N) - 1); // 나누기 0방지 max + 1
        System.out.println(sb);
    }
}