package everyday.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		st.nextToken();
		int W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[W];
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int res = 0;
		for (int i = 0; i < W; i++) {
			int leftH = 0, rightH = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] > leftH) leftH = arr[j];
			}
			for (int j = i + 1; j < W; j++) {
				if (arr[j] > rightH) rightH = arr[j];
			}
			int maxH = Math.min(leftH, rightH);
			res += (maxH - arr[i]) > 0 ? maxH - arr[i] : 0;
		}

		System.out.println(res);
	}
}
