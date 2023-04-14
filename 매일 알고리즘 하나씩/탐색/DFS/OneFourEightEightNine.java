import java.io.*;
import java.util.*;

public class OneFourEightEightNine {
    static int N; // 사람들의 수
    static boolean[][] stTeam, liTeam; // 스타트팀, 링크팀
    static int[][] team; // 모든 사람들의 점수
    static int result = Integer.MAX_VALUE; // 점수
    static Deque<Integer> startNum = new LinkedList<>(); // 스타트팀인지 확인
    static HashSet<Integer> exist; // 존재 여부

    public static void check(){
        int start = 0, link = 0; // 현재 노드의 팀원과 다른 팀원들의 점수합
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(stTeam[i][j]) { // 스타트 팀이면 접수 더함
                    start += team[i][j] + team[j][i];
                }
                else if(liTeam[i][j]) { // 링크 팀이면 접수 더함
                    link += team[i][j] + team[j][i];
                }
            }
        }
        result = Math.min(result, Math.abs(start-link)); // 차이의 최솟값
        return;

    }
    public static void linkMatch() { // 팀 연결
        stTeam = new boolean[N][N];  // 새로운 스타트팀 생성
        liTeam = new boolean[N][N]; // 새로운 링크팀 생성
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(exist.contains(i) && exist.contains(j)){ // start에 존재 하면 스타트팀
                    stTeam[i][j] = true;
                }
                if(!exist.contains(i) && !exist.contains(j)){ // start에 존재 하지 않으면 링크팀
                    liTeam[i][j] = true;
                }
            }
        }
    }

    public static void matching(int node){ // 팀원 매칭
        if(startNum.size() == N / 2) { // 팀원이 다 찼을 때
            exist = new HashSet<>(); // 새로운 스타트를 담기 위해 생성
            int n;
            for(int i = 0; i < N / 2; i++){ // 스타트팀을 exist에 넣음
                n = startNum.pollFirst();
                exist.add(n);
                startNum.offerLast(n);
            }
            linkMatch();
            check();
            return ;
        }
        for(int i = node + 1; i < N; i++){
            startNum.offerLast(i); // 스타트팀에 포함
            matching(i);
            startNum.pollLast(); // 스타트 팀에서 나감
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        team = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        startNum.offer(0); // 스타트팀에 0번째 선수 포함
        matching(0);
        sb.append(result);
        System.out.println(sb);
    }
}