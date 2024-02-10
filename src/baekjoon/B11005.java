package src.baekjoon;

import java.io.*;

public class B11005 {
    // 진법 변환2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);

        String ans = "";
        // 1. X틀 B로 나눈 나머지를 구하고, B로 나눈다. 0이 될 때까지 반복한다.
        while (N > 0) {
            int digit = N % B;
            if (digit < 10) ans += digit;
            else ans += (char)('A' + digit - 10);
            N /= B;
        }
        // 2. 가장 마지막 나머지부터 가장 앞 자릿값이 된다.
        for (int i = ans.length() - 1; i >= 0; i--) {
            bw.write(ans.charAt(i));
        }
        bw.flush();
        bw.close();
    }
}
