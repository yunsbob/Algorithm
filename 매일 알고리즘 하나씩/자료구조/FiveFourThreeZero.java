import java.io.*;
import java.util.*;

public class FiveFourThreeZero {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++){
            StringBuilder num = new StringBuilder();
            String p = br.readLine();
            boolean flag = false;
            int[] order = new int[p.length()];
            for(int i = 0; i < p.length(); i++){
                order[i] = p.charAt(i);
            }

            Integer.parseInt(br.readLine());
            Deque<Integer> N = new LinkedList<>();
            String str = br.readLine();
            if(str.length() > 2){
                for(int i = 0; i < str.length(); i++){
                    switch(str.charAt(i)){
                        case ',' : 
                            N.offer(Integer.parseInt(String.valueOf(num)));
                            num = new StringBuilder();
                            break;
                        case ']' : 
                            N.offer(Integer.parseInt(String.valueOf(num)));
                    }
                    if('0' <= str.charAt(i) && str.charAt(i) <= '9'){
                        num.append(str.charAt(i) - '0');
                    }
                }
            }

            int R = 0;
            for(int i = 0; i < order.length; i++){
                if(order[i] == 'D'){
                    if(N.isEmpty()){
                        flag = true;
                        break;
                    }
                    if(R % 2 == 1){
                        N.pollLast();
                    }
                    else{
                        N.pollFirst();
                    }
                }
                else{
                    R++;
                }
            }
            if(flag){
                sb.append("error\n");
            }
            else {
                int size = N.size();
                if(size == 0){
                    sb.append("[]\n");
                }
                else{
                    sb.append("[");
                    for(int i = 0; i < size; i++){
                        if(i == size - 1){
                            sb.append(N.poll());
                            sb.append("]\n");
                        }
                        else{
                            if(R % 2 == 1){
                                sb.append(N.pollLast() + ",");
                            }
                            else{
                                sb.append(N.pollFirst() + ",");
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
