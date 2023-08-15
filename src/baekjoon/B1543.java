package src.baekjoon;

import java.util.*;

// 문제: 주어진 단어가 문서에 등장하는 횟수
public class B1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();
        int count = 0;
        int startIndex = 0;

        while (true) {
            // indexOf(str, startIndex): 찾지 못 할 경우 -1 리턴
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0) {
                break;
            }
            startIndex = findIndex + word.length();
            count++;
        }
        System.out.print(count);
    }
}
