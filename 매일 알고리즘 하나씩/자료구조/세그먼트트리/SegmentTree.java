public class SegmentTree {
    static int[] arr;
    static int[] tree;

    public static int init(int start, int end, int node){
        if(start == end){
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 +1);
    }

    public static int sum(int start, int end, int node, int left, int right){
        if(left > end || right < start){ // 범위를 벗어난 경우
            return 0;
        }
        if(left <= start && end <= right){ // 범위에 들어온 경우
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int updateIndex, int updateValue){
        if(updateIndex < start || updateIndex > end){ // 범위를 벗어난 경우
            return ;
        }
        tree[node] += updateValue;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, updateIndex, updateValue);
        update(mid + 1, end, node * 2 + 1, updateIndex, updateValue);
    }

    public static void main(String[] args){
        arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = i + 1;
        }
        tree = new int[arr.length * 4]; // 트리 크기는 배열의 4배
        int num = arr.length - 1; // num = 배열의 마지막 인덱스
        
        // 노드만 1부터 시작하고 나머지는 배열의 인덱스로
        init(0, num, 1);
        System.out.println(sum(0, num, 1, 0, 9));
        System.out.println(sum(0, num, 1, 0, 0));
        // 0번 인덱스를 +5로 변경
        update(0, num, 1, 0, 5);
        System.out.println(sum(0, num, 1, 0, 9));
        System.out.println(sum(0, num, 1, 0, 0));
    }
}
