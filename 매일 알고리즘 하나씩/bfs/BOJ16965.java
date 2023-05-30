package everyday.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16965 {
    static int N;
    static List<XY> district = new ArrayList<>();
    static List<List<Integer>> move = new ArrayList<>();

    private static class XY{
        int start, end;

        private XY(){}
        private XY(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        district.add(new XY());
        move.add(new ArrayList<>());
        int now = 1;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if(order == 1){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                district.add(new XY(start, end));
                move.add(new ArrayList<>());

                for(int j = 1; j < now; j++){
                    if(move(district.get(j), district.get(now))) move.get(j).add(now);
                    if(move(district.get(now), district.get(j))) move.get(now).add(j);
                }
                now++;
            }
            else{
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                sb.append(BFS(start, end, now)).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static boolean move(XY o1, XY o2) {
        if((o2.start < o1.start && o1.start < o2.end) ||
                (o2.start < o1.end && o1.end < o2.end)) return true;
        return false;
    }

    private static int BFS(int start, int end, int size) {
        boolean visited[] = new boolean[size];

        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == end) return 1;

            for (int n : move.get(now)) {
                if (!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }

        return 0;
    }
}