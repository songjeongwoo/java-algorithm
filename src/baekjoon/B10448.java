package src.baekjoon;

import java.io.*;

public class B10448 {
    public static int getTriangleNumbers(int[] triangleNumbers, int K) {
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber >= K) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }
        return triangleNumberCount;
    }
    static boolean[] isEurekaNumber = new boolean[1001];
    public static void preprocess() {
        int[] triangleNumbers = new int[50]; // 50은 임의의 수, K는 최대 1_000임으로 K보다 작은 삼각수는 44, 44까지만 만들어도 됨.
        int triangleNumberCount = getTriangleNumbers(triangleNumbers, 1_000);
        for (int i = 0; i < triangleNumberCount; i++)
            for (int j = 0; j < triangleNumberCount; j++)
                for (int k = 0; k < triangleNumberCount; k++) {
                    int sum = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                    if (sum <= 1_000) isEurekaNumber[sum] = true;
                }
    }

    public static void main(String[] args) throws IOException {
        // 시간복잡도 : O(triangleNumberCount + triangleNumberCount^3 + T)
        preprocess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            System.out.println(isEurekaNumber[K] ? "1" : "0");
        }
    }
}
