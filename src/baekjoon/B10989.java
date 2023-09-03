package src.baekjoon;

import java.io.*;

public class B10989 {
    // 최종 시간복잡도: O(N) = 10,000,000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        // 시간복잡도: O(N)
        for (int i = 0; i < N; i++)
            cnt[Integer.parseInt(br.readLine())]++;
        // 시간복잡도: O(max(10,000, N))
        for (int i = 1; i <= 10000; i++) {
            while(cnt[i]-- > 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
