package src;

import java.util.*;
import java.io.*;

public class Main
{
    public static int[] genAlphabetCount(String str) {
        int[] count = new int[26];  // 알파벳 소문자는 26개
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();

        int[] countA = genAlphabetCount(a);
        int[] countB = genAlphabetCount(b);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(countA[i] - countB[i]);
        }
        System.out.println(ans);
    }
}
