package src.baekjoon;

import java.io.*;

// 회문인 수
public class B11068 {
    // 1. 가능한 모든 진법에 대해 진법을 변환한다.  // 시간복잡도: O(log₁X) (cf. 여기서 ₁ = base)
    public static int[] convertBase(int x, int base) {
        int len = 0, copyX = x;
        while (copyX > 0) {
            copyX /= base;
            len++;
        }

        int[] digit = new int[len];
        len = 0;
        while (x > 0) {
            digit[len++] = x % base;
            x /= base;
        }
        return digit;
    }

    // 2. 변환된 수가 회문이 될 수 있는지 확인한다.  // 시간복잡도: O(log₁X) (cf. 여기서 ₁ = base)
    public static boolean isPalindrome(int[] digit) {
        for (int i = 0; i < digit.length / 2; i++) {
            if (digit[i] != digit[digit.length - i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int x = Integer.parseInt(br.readLine());
            boolean ans = false;
            for (int i = 2; i <= 64; i++) {
                int[] digit = convertBase(x, i);
                if (isPalindrome(digit)) {
                    ans = true;
                    break;
                }
            }
            bw.write(ans ? "1" : "0");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
