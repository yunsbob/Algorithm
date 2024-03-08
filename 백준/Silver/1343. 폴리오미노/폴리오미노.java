import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		str = str.replaceAll("XXXX", "AAAA");
		String res = str.replaceAll("XX", "BB");

		if (res.contains("X")) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}
}