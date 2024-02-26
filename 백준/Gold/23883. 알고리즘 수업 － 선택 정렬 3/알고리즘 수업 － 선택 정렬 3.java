import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		TreeMap<Integer, Integer> tree = new TreeMap<>();
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			tree.put(num, i);
			arr[i] = num;
		}

		int cnt = 0;
		for (int i = N; i > 0; i--) {
			int num = tree.pollLastEntry().getValue();

			if (num == i) continue;

			cnt++;

			swap(i, num);
			tree.put(arr[num], num);

			if (cnt == K) {
				System.out.println(arr[num] + " " + arr[i]);
				System.exit(0);
			}
		}

		System.out.println(-1);
	}

	private static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}