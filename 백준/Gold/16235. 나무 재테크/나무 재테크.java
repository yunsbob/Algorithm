import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] map;
	private static int[][] foods;
	private static int[][] dir = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
	private static Queue<Tree> trees = new ArrayDeque<>();
	private static Queue<Tree> deadTrees = new ArrayDeque<>();

	private static class Tree implements Comparable<Tree> {
		int x, y, age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		foods = new int[N + 1][N + 1];
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
				foods[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Tree> inputList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());

			inputList.add(new Tree(x, y, age));
		}

		Collections.sort(inputList);
		for (Tree tree : inputList) {
			trees.offer(tree);
		}

		while (K-- > 0) {
			spring();
			summer();
			autumn();
			winter();
		}

		System.out.println(trees.size());
	}

	private static void spring() {
		int size = trees.size();

		while (size-- > 0) {
			Tree tree = trees.poll();

			if (map[tree.x][tree.y] >= tree.age) {
				map[tree.x][tree.y] -= tree.age;
				trees.offer(new Tree(tree.x, tree.y, tree.age + 1));
			} else {
				deadTrees.offer(tree);
			}
		}

	}

	private static void summer() {
		while (!deadTrees.isEmpty()) {
			Tree tree = deadTrees.poll();
			map[tree.x][tree.y] += tree.age / 2;
		}
	}

	private static void autumn() {
		Queue<Tree> aliveTrees = new ArrayDeque<>();
		int size = trees.size();

		while (size-- > 0) {
			Tree tree = trees.poll();

			if (tree.age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int nx = tree.x + dir[j][0];
					int ny = tree.y + dir[j][1];

					if (nx <= 0 || ny <= 0 || nx > N || ny > N)
						continue;
					trees.offer(new Tree(nx, ny, 1));
				}
			}

			aliveTrees.offer(tree);
		}

		while (!aliveTrees.isEmpty()) {
			trees.offer(aliveTrees.poll());
		}
	}

	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += foods[i][j];
			}
		}
	}
}