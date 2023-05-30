package everyday.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16496 {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	list.add(st.nextToken());
        }
        
        Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        String str = "";
		for(int i = 0; i < N; i++) {
			str += list.get(i);
			if(i == 0 && str.equals("0")) break;
		}
		System.out.println(str);
	}
}
