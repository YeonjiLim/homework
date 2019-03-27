import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	
	public int[] nRStair = new int[2];
	public int[] nCStair = new int[2];
	public int[] stairValue = new int[2];
	public ArrayList<Person> persons = new ArrayList<>();
	
	public int min;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			int N = Integer.parseInt(str);
			persons.clear();
			min = 999;
			int sIndex = 0;
			for(int row = 0; row < N; row++) {
				String[] s = br.readLine().split(" ");
				for(int col = 0; col < N; col++) {
					if(Integer.parseInt(s[col]) == 1) {
						persons.add(new Person(row, col));
					}else if(Integer.parseInt(s[col]) > 1) {
						nRStair[sIndex] = row;
						nCStair[sIndex] = col;
						stairValue[sIndex] = Integer.parseInt(s[col]);
						sIndex++;
					}
				}
			}
			powerset(persons.size());
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public void powerset(int n) {
		int[] selectInfo = new int[n];
		Arrays.fill(selectInfo, 0);
		for(int i = 0; i < (1<<n); i++) {
			Arrays.fill(selectInfo, 0);
			for(int j = 0; j < n; j++) {
				if((i & (1<<j)) != 0) {
					selectInfo[j] = 1;
				}
			}
			calculate(selectInfo);
		}
		
	}
	
	public void calculate(int[] arr) {
		ArrayList<Person> s1Person = new ArrayList<>();
		ArrayList<Person> s2Person = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) { // 1번계단 선택
				s1Person.add(persons.get(i));
			} else if(arr[i] == 1) { // 2번계단 선택
				s2Person.add(persons.get(i));
			}
		}
		Collections.sort(s1Person, new CompToStair(0));
		Collections.sort(s2Person, new CompToStair(1));
		int s1Time = 0;
		if(!s1Person.isEmpty()) {			
			int s1Time2 = 0;
			Person p1s = s1Person.get(s1Person.size()-1);
			s1Time2 = Math.abs(p1s.row-nRStair[0]) + Math.abs(p1s.col-nCStair[0]) + 1 + stairValue[0]; // 거리 + 대기시간 1분 + 내려가기
			if(s1Person.size() > 3) {
				Person p1f = s1Person.get(s1Person.size()-4);
				s1Time = Math.abs(p1f.row-nRStair[0]) + Math.abs(p1f.col-nCStair[0]) + 1 + stairValue[0];
				if(s1Time2 - s1Time < stairValue[0]) {
					s1Time += stairValue[0];
				} else {
					s1Time = s1Time2;
				}
			} else {
				s1Time = s1Time2;
			}
		}
		int s2Time = 0;
		if(!s2Person.isEmpty()) {	
			int s2Time2 = 0;
			Person p2s = s2Person.get(s2Person.size()-1);
			s2Time2 = Math.abs(p2s.row-nRStair[1]) + Math.abs(p2s.col-nCStair[1]) + 1 + stairValue[1];
			if(s2Person.size() > 3) {
				Person p2f = s2Person.get(s2Person.size()-4);
				s2Time = Math.abs(p2f.row-nRStair[1]) + Math.abs(p2f.col-nCStair[1]) + 1 + stairValue[1];
				if(s2Time2 - s2Time < stairValue[1]) {
					s2Time += stairValue[1];
				} else {
					s2Time = s2Time2;
				}
			} else {
				s2Time = s2Time2;
			}
		}
		if(s1Person.isEmpty()) {
			if(min > s2Time) {
				min = s2Time;
			}	
		}
		
		if(s2Person.isEmpty()) {
			if(min > s1Time) {
				min = s1Time;
			}
		}
		if(!s1Person.isEmpty() && !s2Person.isEmpty()) {			
			if(s1Time < s2Time) {
				if(min > s2Time) {
					min = s2Time;
				}
			} else {
				if(min > s1Time) {
					min = s1Time;
				}
			}
		}
		
	}
	
	public class Person {
		public int row;
		public int col;
		public Person(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public class CompToStair implements Comparator<Person> {
		
		public int stair;
		
		public CompToStair(int stair) {
			this.stair = stair;
		}
		
		@Override
		public int compare(Person p1, Person p2) {
			int p1Time = Math.abs(p1.row-nRStair[stair]) + Math.abs(p1.col-nCStair[stair]);
			int p2Time = Math.abs(p2.row-nRStair[stair]) + Math.abs(p2.col-nCStair[stair]);
			if(p1Time > p2Time) {
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Solution s2383 = new Solution();
		s2383.solve();
	}
}