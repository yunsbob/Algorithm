import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class OneTwoSixNine {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }        

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        for(int num : A){
            if(B.contains(num)){
                continue;
            }
            else{
                result++;
            }
        }
        for(int num : B){
            if(A.contains(num)){
                continue;
            }
            else{
                result++;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}
