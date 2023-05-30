package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ24444 {
	static int[] visited;
	static boolean[] visit;
	static List<ArrayList<Integer>> arr = new ArrayList<>();
	static int N, cnt = 1; // cnt는 몇 번째 방문인지 알려줌
    static Queue<Integer> q = new LinkedList<>();
	
	public static void BFS(int node) {
        
        q.offer(node); // 시작 노드 입력
		visit[node] = true;
        while(!q.isEmpty()){ // 모든 연결된 노드 탐색이 끝날때까지
            node = q.poll();
			visited[node] = cnt++; // 노드 방문
            for(int i = 0; i < arr.get(node).size(); i++) { // 오름차 순으로 방문
                if(!visit[arr.get(node).get(i)]) { // 현재 노드와 연결된 i노드에 방문한 적이 없을 경우
                    visit[arr.get(node).get(i)] = true; // 중복처리
					q.offer(arr.get(node).get(i));
                }
            }
        }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 노드 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수
		int R = Integer.parseInt(st.nextToken()); // 시작 노드
		visited = new int[N + 1];
		visit = new boolean[N + 1];
		
        for(int i = 0; i <= N; i++) { // 노드 추가
            arr.add(new ArrayList<>()); // 노드당 리스트 존재
        }
		for(int i = 0; i < M; i++) { // 노드 연결
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b); // a - b 두 노드 연결 양방향 간선이므로 동시 입력
			arr.get(b).add(a); // a 리스트에 b 입력, b 리스트에 a 입력
		}
		for(int i = 1; i <= N; i++){
            Collections.sort(arr.get(i)); // 오름차순 방문을 위해 정렬
        }
		BFS(R); // R부터 BFS 시작
		for(int i = 1; i <= N; i++){
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb);
	}
}