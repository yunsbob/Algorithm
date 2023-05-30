package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("add")){
                hs.add(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                if(hs.contains(num)){
                    hs.remove(num);
                }
            }
            else if(order.equals("check")){
                if(hs.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            else if(order.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(hs.contains(num)){
                    hs.remove(num);
                }
                else{
                    hs.add(num);
                }
            }
            else if(order.equals("all")){
                for(int j = 1; j <= 20; j++){
                    if(hs.contains(j)){
                        hs.remove(j);
                    }
                    else{
                        hs.add(j);
                    }
                }
            }
            else if(order.equals("empty")){
                hs = new HashSet<>();
            }
        }
        System.out.println(sb);
    }
}
