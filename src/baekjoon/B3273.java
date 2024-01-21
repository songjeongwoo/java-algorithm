package src.baekjoon;

import java.io.*;

public class B3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] a = new int[N];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(nums[i]);
        }
        int X = Integer.parseInt(br.readLine());

        boolean[] exist = new boolean[1_000_001];
        for (int i = 0; i < N; i++)
            exist[a[i]] = true;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int pairValue = X - a[i];
            if (0 <= pairValue && pairValue <= 1_000_000)
                ans += exist[pairValue] ? 1 : 0;
        }
        bw.write(ans / 2 + "\n");
        bw.flush();
        bw.close();
    }
}
