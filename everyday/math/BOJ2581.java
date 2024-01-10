package everyday.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] nums = {A, B, C};
		Arrays.sort(nums);

		if(nums[0] + nums[1] > nums[2]){
			System.out.println(A + B + C);
		} else{
			System.out.println((nums[0] + nums[1]) * 2 - 1);
		}

	}
}
