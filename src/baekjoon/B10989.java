package src.baekjoon;

import java.util.*;

public class B10989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        arr = Arrays.stream(arr).sorted().toArray();
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
