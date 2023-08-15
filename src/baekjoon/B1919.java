package src.baekjoon;

import java.util.*;

// 문제: 두 단어를 애너그램으로 만들기 위해 제거해야하는 문자의 최소 개수
// cf. 애너그램: 단어의 구성(알파벳과 그 개수)이 완전히 같은 단어
public class B1919
{
    public static int[] genAlphabetCount(String str) {
        int[] count = new int[26];  // 알파벳 소문자는 26개
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
    public static void main(String[] args)
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
