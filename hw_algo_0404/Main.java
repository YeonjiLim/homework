import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main  {
     
    public int[][] map;
    // down, right, right-down, right-up
    public int[] moveR = {1, 0, 1, -1};
    public int[] moveC = {0, 1, 1, 1};
     
    public boolean isFind;
     
    public void calculate(int row, int col) {
        isFind = false;
        for(int m = 0; m < 4; m++) {
            int cnt = 0;
            for(int c = 1; c < 5; c++) {
                int nxtR = row+(moveR[m]*c);
                int nxtC = col+(moveC[m]*c);
                if(nxtR >= 1 && nxtR < 20 && nxtC >= 1 && nxtC < 20) {                  
                    if(map[row][col] != 0 && map[nxtR][nxtC] == map[row][col]) {
                        cnt++;
                    }
                    int nxtR1 = row+(moveR[m]*(c+1));
                    int nxtC1 = col+(moveC[m]*(c+1));
                    int nxtR2 = row+(moveR[m]*(-1));
                    int nxtC2 = col+(moveC[m]*(-1));
                    if(cnt == 4) {
                        boolean isOK = true;
                        if(nxtR1 >= 1 && nxtR1 < 20 && nxtC1 >= 1 && nxtC1 < 20) {
                            if(map[nxtR1][nxtC1] == map[row][col]) {
                                isOK = false;
                            }
                        }
                        if(nxtR2 >= 1 && nxtR2 < 20 && nxtC2 >= 1 && nxtC2 < 20) {
                            if(map[nxtR2][nxtC2] == map[row][col]) {
                                isOK = false;
                            }
                        }
                        if(isOK) {
                            System.out.println(map[row][col]);
                            System.out.println(row + " " + col);
                            isFind = true;
                        }
                    }
                }
            }
            if(isFind) {
                break;
            }
        }
    }
     
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[20][20];
        for(int row = 1; row < 20; row++) {
            String[] s = br.readLine().trim().split(" ");
            for(int col = 1; col < 20; col++) {
                map[row][col] = Integer.parseInt(s[col-1]);
            }
        }
        for(int row = 1; row < 20; row++) {
            for(int col = 1; col < 20; col++) {
                calculate(row, col);
                if(isFind) {
                    break;
                }
            }
            if(isFind) {
                break;
            }
        }
         
        if(!isFind) {
            System.out.println("0");
        }
    }
     
    public static void main(String[] args) throws IOException {
        Main m1733 = new Main();
        m1733.solve();
    }
}