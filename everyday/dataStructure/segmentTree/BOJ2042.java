package everyday.dataStructure.segmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2042 {
    static long[] arr, tree;

    public static long init(int start, int end, int node){
        if(start == end){
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 +1);
    }

    public static long sum(int start, int end, int node, int left, int right){
        if(left > end || right < start){
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int updateIndex, long updateValue){
        if(updateIndex < start || updateIndex > end){
            return ;
        }
        tree[node] += updateValue;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, updateIndex, updateValue);
        update(mid + 1, end, node * 2 + 1, updateIndex, updateValue);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[N * 4];

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        init(0, N - 1, 1);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order == 1){
                int index = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                update(0, N - 1, 1, index - 1, value - arr[index - 1]);
                arr[index - 1] = value;
            }
            else if(order == 2){
                sb.append(sum(0, N - 1, 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1) + "\n");
            }
        }
        System.out.println(sb);
    }
}
