import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int max = n * 2;
		int[] arr = new int[max];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < max; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		max--;

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			res = Math.min(res, arr[i] + arr[max - i]);
		}

		System.out.println(res);
	}
}