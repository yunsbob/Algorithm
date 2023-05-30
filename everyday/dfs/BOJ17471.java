package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17471 {
	static List<List<Integer>> list = new ArrayList<>(); // 인접한 구역
	static int[] people; // 구역별 인구 수
	static boolean[] select; // 구역 나누기
	static boolean[] visited; // 방문 체크
	static int N; // 구역 수
	static int result = Integer.MAX_VALUE; // 결과 값
	static int sum1, sum2; // 구역별 인구 수
	static int cnt; // 구역 전체다 방문했는지 확인할 카운트 변수
	
	static void peoplecount(int now, boolean flag) {
		visited[now] = true;
		cnt++;
		for(int n : list.get(now)) {
			if(!visited[n] && select[n] == flag) {
				sum1 += people[n];
				peoplecount(n, flag);
			}
		}
	}
	
	static void peoplecount2(int now, boolean flag) {
		visited[now] = true;
		cnt++;
		for(int n : list.get(now)) {
			if(!visited[n] && select[n] == flag) {
				sum2 += people[n];
				peoplecount2(n, flag);
			}
		}
	}
	
	static void select(int district) {
		if(district == N + 1) {
			Arrays.fill(visited, false);
			sum1 = sum2 = cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(select[i]) {
					peoplecount(i, true);
					break;
				}
			}
			for(int i = 1; i <= N; i++) {
				if(!select[i]) {
					peoplecount2(i, false);
					break;
				}
			}
			if(cnt == N) {
				result = Math.min(result, Math.abs(sum1 - sum2));
			}
		}
		else {
			select[district] = true;
			select(district + 1);
			select[district] = false;
			select(district + 1);
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        people = new int[N + 1];
        select = new boolean[N + 1];
        visited = new boolean[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	people[i] = Integer.parseInt(st.nextToken());
        }
        
    	list.add(new ArrayList<Integer>());
        for(int i = 1; i <= N; i++) {
        	list.add(new ArrayList<Integer>());
        	st = new StringTokenizer(br.readLine());
        	int size = Integer.parseInt(st.nextToken());
        	for(int j = 0; j < size; j++) {
        		list.get(i).add(Integer.parseInt(st.nextToken()));
        	}
        }
        
        select(1);
        if(result == Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(result);
        }
	}
}