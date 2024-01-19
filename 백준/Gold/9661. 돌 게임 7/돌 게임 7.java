import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Long N = Long.parseLong(br.readLine());
		if (N % 5 == 0 || N % 5 == 2)
			System.out.println("CY");
		else
			System.out.println("SK");
	}
}