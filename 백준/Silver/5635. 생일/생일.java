import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = st.nextToken();
			arr[i][3] = st.nextToken();
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[3].equals(o2[3])) {
				if (o1[2].equals(o2[2])) {
					return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
				}
				return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);

			}
			return o2[3].compareTo(o1[3]);
		});

		System.out.println(arr[0][0]);
		System.out.println(arr[N - 1][0]);
	}
}