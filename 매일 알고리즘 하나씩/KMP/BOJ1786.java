package everyday.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1786 {
	static int[] table;
	static char[] text, pattern;
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		text = br.readLine().toCharArray();
		pattern = br.readLine().toCharArray();
		
		makeTable();
		searchTable();
		
		sb.append(result.size()).append('\n');
		for(int res : result) {
			sb.append(res).append('\n');
		}
		System.out.println(sb);
	}
	
	static void makeTable() {
		table = new int[pattern.length];
		
		int idx = 0;
		for(int i = 1; i < pattern.length; i++) {
			while(idx > 0 && pattern[i] != pattern[idx]) idx = table[idx-1];
			
			if(pattern[i] == pattern[idx]) {
				table[i] = ++idx;
			}
		}
	}
	
	static void searchTable() {
		int idx = 0;
		for(int i = 0; i < text.length; i++) {
			while(idx > 0 && text[i] != pattern[idx]) idx = table[idx-1];
			
			if(text[i] == pattern[idx]) {
				if(idx == pattern.length - 1) {
					result.add(i - idx + 1);
					idx = table[idx];
				}
				else idx++;
			}
		}
	}
}