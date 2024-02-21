import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, del, res = 0;
	private static List<List<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		int root = 0;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
				continue;
			}
			tree.get(parent).add(i);
		}

		del = Integer.parseInt(br.readLine());
		if (del == root) {
			System.out.println(0);
		}
		else {
			dfs(root);
			System.out.println(res);
		}
	}

	private static void dfs(int now) {
		if (tree.get(now).isEmpty()) {
			res++;
			return;
		}

		for (Integer child : tree.get(now)) {
			if (child == del) {
				if (tree.get(now).size() == 1) res++;
				continue;
			}
			dfs(child);
		}
	}
}