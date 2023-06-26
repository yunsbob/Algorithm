package everyday.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14369 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] num = {"ZERO", "SIX", "EIGHT", "SEVEN", "THREE", "TWO", "FIVE", "FOUR", "ONE", "NINE"};
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            List<Integer> list = new ArrayList<>();
            int[] arr = new int[26];
            String S = br.readLine();
            for (int j = 0; j < S.length(); j++) {
                arr[S.charAt(j) - 'A']++;
            }
            if (arr['Z' - 'A'] > 0) {
                int cnt = arr['Z' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(0);
                }
                for (int j = 0; j < num[0].length(); j++) {
                    arr[num[0].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['X' - 'A'] > 0) {
                int cnt = arr['X' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(6);
                }
                for (int j = 0; j < num[1].length(); j++) {
                    arr[num[1].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['G' - 'A'] > 0) {
                int cnt = arr['G' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(8);
                }
                for (int j = 0; j < num[2].length(); j++) {
                    arr[num[2].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['S' - 'A'] > 0) {
                int cnt = arr['S' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(7);
                }
                for (int j = 0; j < num[3].length(); j++) {
                    arr[num[3].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['H' - 'A'] > 0) {
                int cnt = arr['H' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(3);
                }
                for (int j = 0; j < num[4].length(); j++) {
                    arr[num[4].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['W' - 'A'] > 0) {
                int cnt = arr['W' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(2);
                }
                for (int j = 0; j < num[5].length(); j++) {
                    arr[num[5].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['V' - 'A'] > 0) {
                int cnt = arr['V' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(5);
                }
                for (int j = 0; j < num[6].length(); j++) {
                    arr[num[6].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['F' - 'A'] > 0) {
                int cnt = arr['F' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(4);
                }
                for (int j = 0; j < num[7].length(); j++) {
                    arr[num[7].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['O' - 'A'] > 0) {
                int cnt = arr['O' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(1);
                }
                for (int j = 0; j < num[8].length(); j++) {
                    arr[num[8].charAt(j) - 'A'] -= cnt;
                }
            }
            if (arr['I' - 'A'] > 0) {
                int cnt = arr['I' - 'A'];
                for (int j = 0; j < cnt; j++) {
                    list.add(9);
                }
                for (int j = 0; j < num[9].length(); j++) {
                    arr[num[9].charAt(j) - 'A'] -= cnt;
                }
            }
            Collections.sort(list);
            sb.append("Case #").append(i).append(": ");
            for (int n: list) {
                sb.append(n);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
