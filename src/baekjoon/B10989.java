package src.baekjoon;

import java.util.*;

public class B10989 {
    // 최종 시간복잡도: O(N) = 10,000,000
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] cnt = new int[10001];
        // 시간복잡도: O(N)
        for (int i = 0; i < N; i++)
            cnt[sc.nextInt()]++;
        // 시간복잡도: O(max(10,000, N))
        for (int i = 1; i <= 10000; i++) {
            while(cnt[i]-- > 0) {
                System.out.println(i);
            }
        }
    }
}
