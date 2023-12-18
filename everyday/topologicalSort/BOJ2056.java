package everyday.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2056 {
	private static int N;
	private static int[] endV, time;
	private static List<List<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		endV = new int[N + 1];
		time = new int[N + 1];

		list = new ArrayList<>();
		list.add(new ArrayList<>());
		for (int i = 1; i <= N; i++) {
			list.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				list.get(Integer.parseInt(st.nextToken())).add(i);
				endV[i]++;
			}
		}

		System.out.println(topoSort());
	}

	private static int topoSort() {
		Queue<Integer> q = new ArrayDeque<>();
		int[] endT = new int[N + 1];

		for(int i = 1; i <= N; i++) {
			endT[i] = time[i];
			if(endV[i] == 0) q.add(i);
		}

		while(!q.isEmpty()) {
			int now = q.poll();

			for(Integer v : list.get(now)) {
				endV[v]--;
				endT[v] = Math.max(endT[v], endT[now] + time[v]);
				if(endV[v] == 0) {
					q.offer(v);
				}
			}
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, endT[i]);
		}
		return res;
	}
}
