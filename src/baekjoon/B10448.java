package src.baekjoon;

import java.io.*;

public class B10448 {
    static boolean[] isEurekaNumber = new boolean[1001];
    public static void preprocess() {
        // 1. K보다 작은 삼각수를 모두 구한다.
        int[] triangleNumbers = new int[50]; // 50은 임의의 수, K는 최대 1_000임으로 K보다 작은 삼각수는 44, 44까지만 만들어도 됨.
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;  // 삼각수 구하는 공식(등차수열의 합)
            if (triangleNumber >= 1000) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }
        // 2. 구해진 삼각수 세 개의 합으로 K를 나타낼 수 있는 지 확인한다.
        // 2-1. 시간복잡도를 줄이기 위해 삼각수 두 수의 합들을 구해둔다.
        boolean[] isSumOfTriangleNumber = new boolean[1000];
        for (int i = 0; i < triangleNumberCount; i++)
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) isSumOfTriangleNumber[sum] = true;
            }
        /* 시간복잡도 = ↑ : O(triangleNumberCount^2), ↓ : O(K * triangleNumberCount), 따라서 더 큰 O(K * triangleNumberCount)가 된다. */
        // 2-2. 이미 구해둔 두 삼각수의 합 + 삼각수
        for (int i = 1; i < 1000; i++) {
            if (!isSumOfTriangleNumber[i]) continue;  // 두 개의 합이 삼각수가 아니라면 패스
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = i + triangleNumbers[j];  // i = 이미 구해둔 두 삼각수의 합
                if (sum <= 1000) isEurekaNumber[sum] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // [3, 1000]
        // isEurekaNumber[]
        // 기존 시간복잡도 : O(triangleNumberCount + triangleNumberCount^3 + T)
        // 개선된 시간복잡도 : O(K * triangleNumberCount + T)
        preprocess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            System.out.println(isEurekaNumber[K] ? "1" : "0");
        }
    }
}
