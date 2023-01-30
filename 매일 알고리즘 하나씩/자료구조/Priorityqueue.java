import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Priorityqueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> Pqueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                if(Pqueue.isEmpty()){
                    sb.append(0 + "\n");
                }
                else{
                    sb.append(Pqueue.poll() + "\n");
                }
            }
            else{
                Pqueue.offer(num);
            }
        }
        System.out.println(sb);
    }
}
