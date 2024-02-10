package src.baekjoon;

import java.io.*;

// ACM 호텔
public class B10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] nums = br.readLine().split(" ");
            int H = Integer.parseInt(nums[0]);
            int W = Integer.parseInt(nums[1]);
            int N = Integer.parseInt(nums[2]);

            int distance = (N - 1) / H + 1;  // 호
            int floor = (N - 1) % H + 1;  // 층
            System.out.printf("%d%02d\n", floor, distance);
        }
    }
}
