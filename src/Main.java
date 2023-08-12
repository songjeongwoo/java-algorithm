package src;

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();

        int[] countA = new int[26];  // 알파벳 소문자는 26개
        int[] countB = new int[26];
        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            countB[b.charAt(i) - 'a']++;
        }

        int cns = 0;
        for (int i = 0; i < 26; i++) {
            if (countA[i] > countB[i]) {
                cns += countA[i] - countB[i];
            } else {
                cns += countB[i] - countA[i];
            }
        }
        System.out.println(cns);
    }
}
