import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(order.equals("I")) {
                    tMap.put(num, tMap.getOrDefault(num, 0) + 1);
                }
                else if(order.equals("D")) {
                    if (num == 1) {
                        if (tMap.isEmpty()) {
                            continue;
                        }
                        else {
                            int n = tMap.lastKey();
                            if(tMap.put(n, tMap.get(n) - 1) == 1) {
                                tMap.remove(n);
                            }
                        }
                    }
                    if (num == -1) {
                        if (tMap.isEmpty()) {
                            continue;
                        }
                        else {
                            int n = tMap.firstKey();
                            if(tMap.put(n, tMap.get(n) - 1) == 1) {
                                tMap.remove(n);
                            }
                        }
                    }
                }
            }
            if(tMap.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(tMap.lastKey() + " " + tMap.firstKey() + "\n");
            }
        }
        System.out.println(sb);
    }
}
