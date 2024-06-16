import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int res = 0;
		for (int i = 0; i < 6; i++) {
			res += arr[i] % T == 0 ? arr[i] / T : arr[i] / T + 1;
		}

		System.out.println(res + "\n" + N / P + " " + N % P);
	}
}