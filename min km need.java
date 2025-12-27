Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Input Format

array size and elements

Constraints

m == grid.length n == grid[i].length 1 <= m, n <= 200 0 <= grid[i][j] <= 200

Output Format

print the min km

Sample Input 0

3 3
1 2 3
4 8 2
1 5 3

Sample Output 0

8

Explanation 0

(0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3)

---------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        System.out.println(dp[m-1][n-1]);
    }
}


