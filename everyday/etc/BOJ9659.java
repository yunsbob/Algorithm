package everyday.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Long N = Long.parseLong(br.readLine());
		if (N % 2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}
}
