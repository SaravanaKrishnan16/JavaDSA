Given a 2D matrix, the task is that we find maximum sum of a hour glass and print the matrix.

Input Format

size of the array and followed by array elements

Constraints

if hour glass is not there means print -1

Output Format

print the max sum sand glass

Sample Input 0

3 3
1 1 1
2 2 2
3 3 3
  
Sample Output 0

1 1 1
  2  
3 3 3

-------------------------------------------------------------------------------------------------------

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        if (r<3||c<3) {
            System.out.println(-1);
            return;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;
        for (int i=0;i<=r-3;i++) {
            for (int j=0;j<=c-3;j++) {
                int sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+
                          arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                if (sum>maxSum) {
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println(
                arr[maxRow][maxCol]+" "+
                arr[maxRow][maxCol+1]+ " "+
                arr[maxRow][maxCol+2] );
        System.out.println("  "+arr[maxRow+1][maxCol+1]+"  ");
        System.out.println(
                arr[maxRow+2][maxCol]+" "+
                arr[maxRow+2][maxCol+1]+ " " +
                arr[maxRow+2][maxCol+2] );
    }
}
