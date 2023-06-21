package everyday.tree.segmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2243 {
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new int[4 * 1000000];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if (A == 1) {
                int B = Integer.parseInt(st.nextToken());
                int res = binarySearch(1, 1000000, B);
                sb.append(res).append('\n');
                update(1, 1000000, 1, res, -1);
            }
            else {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                update(1, 1000000, 1, B, C);
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = sum(1, 1000000, 1, 1, mid);
            if (sum < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    public static int sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start){
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void update(int start, int end, int node, int updateIndex, long updateValue) {
        if(updateIndex < start || updateIndex > end){
            return ;
        }
        tree[node] += updateValue;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, updateIndex, updateValue);
        update(mid + 1, end, node * 2 + 1, updateIndex, updateValue);
    }
}
