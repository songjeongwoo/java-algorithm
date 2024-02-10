package src.baekjoon;

import java.io.*;

// 사탕 게임
public class B3085 {
    // 1. 가능한 모든 쌍의 사탕을 서로 교환한다.
    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }

    // 2. 교환한 상타에서 가장 긴 연속 부분 행/열을 찾는다. - targetColor 변수를 이용해 연속성을 판단하는 방법

    public static int findMaxRow(char[][] map) {  // 가장 긴 연속 열(가로)  // 시간복잡도: O(N²)
        int N = map.length;
        int maxRow = 0;
        for (int r = 0; r < N; r++) {
            int len = 0;
            int currentColor = map[r][0];
            for (int c = 0; c < N; c++) {
                if (map[r][c] == currentColor) len++;
                else {
                    currentColor = map[r][c];
                    len = 1;
                }
                maxRow = Math.max(maxRow, len);
            }
        }
        return maxRow;
    }

    public static int findMaxColumn(char[][] map) {  // 가장 긴 연속 행(세로)  // 시간복잡도: O(N²)
        int N = map.length;
        int maxColumn = 0;
        for (int c = 0; c < N; c++) {
            int len = 0;
            int currentColor = map[0][c];
            for (int r = 0; r < N; r++) {
                if (map[r][c] == currentColor) len++;
                else {
                    currentColor = map[r][c];
                    len = 1;
                }
                maxColumn = Math.max(maxColumn, len);
            }
        }
        return maxColumn;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        // 전체 시간복잡도: O(N² * (2N² + 2N²)) = O(N⁴)
        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i, j + 1);
                }
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i + 1, j);
                }
            }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
