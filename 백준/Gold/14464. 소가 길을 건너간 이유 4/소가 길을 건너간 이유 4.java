import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] chicken = new int[C];
		int[][] cow = new int[N][2];
		boolean[] check = new boolean[N];
		for (int i = 0; i < C; i++) {
			chicken[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cow[i][0] = Integer.parseInt(st.nextToken());
			cow[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cow, (o1, o2) -> o1[1] - o2[1]);
		Arrays.sort(chicken);

		int res = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < N; j++) {
				if (check[j]) continue;
				if (cow[j][0] <= chicken[i] && chicken[i] <= cow[j][1]) {
					check[j] = true;
					res++;
					break;
				}
			}
		}

		System.out.println(res);
	}
}