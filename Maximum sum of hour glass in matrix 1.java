Given a 2D matrix, the task is that we find maximum sum of a hour glass. if it's not possible print -1

Input Format

size of the array and followed by array elements

Output Format

print the max sum

Sample Input 0

5 5
0 3 0 0 0
0 1 0 0 0
1 1 1 0 0
0 0 2 4 4
0 0 0 2 4

Sample Output 0

11

Explanation 0
Below is the hour glass with maximum sum
1 0 0
4
0 2 4

------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] mat = new int[r][c];

        for (int i=0;i<r;i++) {
            for (int j =0;j<c;j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        if (r<3 || c<3) {
            System.out.println(-1);
            return;
        }

        int max = Integer.MIN_VALUE;

        for (int i=0;i<=r-3;i++) {
            for (int j=0;j<=c-3;j++) {
                int sum = mat[i][j]+mat[i][j+1]+mat[i][j+2]+mat[i+1][j+1]
                        + mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2];
                max = Math.max(max,sum);
            }
        }
        System.out.println(max);
    }
}

