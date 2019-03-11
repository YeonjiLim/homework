package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main2247 {
	
	public ArrayList<RecordTime> arrTimes;
	public int useS, useE, use;
	public int noE, no;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		arrTimes = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().trim().split(" ");
			int S = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			arrTimes.add(new RecordTime(S, E));
		}
		Collections.sort(arrTimes, new CompareTime());
		
		for(int i = 0; i < arrTimes.size(); i++) {
			System.out.println(arrTimes.get(i).start + " " + arrTimes.get(i).end);
		}

		useS = arrTimes.get(0).start;
		useE = arrTimes.get(0).end;
		use = 0;
		for(int idx = 1; idx < arrTimes.size(); idx++) {
			if(arrTimes.get(idx).start >= useS && arrTimes.get(idx).start <= useE) {
				useE = (arrTimes.get(idx).end > useE) ? arrTimes.get(idx).end : useE;
//				System.out.println("useS:" + useS + ", useE:" + useE + ", use:" + use);
			}
			if(arrTimes.get(idx).start > useE) {
//				System.out.println("useS:" + useS + ", useE:" + useE + ", use:" + use);
				if(use < useE-useS) {					
					use = useE-useS;
				}
				useS = arrTimes.get(idx).start;
				useE = arrTimes.get(idx).end;
			}
//			System.out.println("useS:" + useS + ", useE:" + useE + ", use:" + use);
		}
		
		if(use < useE-useS) {					
			use = useE-useS;
		}
		
		no = 0;
		noE = arrTimes.get(0).end;
		for(int idx = 0; idx < arrTimes.size()-1; idx++) {
			if(noE < arrTimes.get(idx).end) {
				noE = arrTimes.get(idx).end;
			}
			if(noE < arrTimes.get(idx+1).start) {
				if(no < arrTimes.get(idx+1).start-noE) {
					no = arrTimes.get(idx+1).start-noE;
//					System.out.println(no);
				}
			}
		}
		
		System.out.println(use + " " + no);
	}
	
	class CompareTime implements Comparator<RecordTime>{

		@Override
		public int compare(RecordTime o1, RecordTime o2) {
			if(o1.start > o2.start) {
				return 1;
			} else if(o1.start < o2.start) {
				return -1;
			} else {
				if(o1.end > o2.end) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		
	}
	
	class RecordTime {
		int start;
		int end;
		public RecordTime(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main2247 m2247 = new Main2247();
		m2247.solve();
	}
}
