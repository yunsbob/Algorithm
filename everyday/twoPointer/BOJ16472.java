package everyday.twoPointer;

import sun.nio.cs.ext.MacHebrew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] check = new int[26];
        int s = 0, res = 0, cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            check[str.charAt(i) - 'a']++;
            if (check[str.charAt(i) - 'a'] == 1) cnt++;
            if (cnt <= N) res = Math.max(res, i - s + 1);
            else {
                while (true) {
                    check[str.charAt(s) - 'a']--;
                    if (check[str.charAt(s++) - 'a'] == 0) {
                        cnt--;
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
