import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

    public static class Top {
        int h;
        int x;
        public Top(int h, int x){
            this.h = h;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        for(int i = 1; i <= N; i++){
            int h = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if(stack.peek().h >= h) {
                    sb.append(stack.peek().x).append(' ');
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append('0').append(' ');
            }
            stack.push(new Top(h, i)); 
        }
        System.out.println(sb);
    }
}
