You are given a matrix representing bus seats. Each seat can be:

0 → Empty seat

1 → Occupied by a Female

2 → Occupied by a Male

You are also given:

n → number of rows

m → number of columns

n × m matrix of seat values

r, c → desired seat position

g → gender of the person trying to book (1 for female, 2 for male)

You must check if the seat at position (r, c) can be booked.

Rule 1 — Seat must be empty

The given seat must contain value 0.

Rule 2 — Gender constraint (only for male = 2)

If the person is male (g = 2):

Check all four directions (if they exist):

Left,Right,Up and down.

If any of these seats contains 1 (female) → booking is not allowed.

Input Format

n m matrix of size n × m r c g

Constraints

NA

Output Format

Seat Booked Cannot Book Seat

Sample Input 0

3 4
0 2 0 1
0 0 0 0
1 0 2 0
1 2
2

Sample Output 0

Seat Booked

Sample Input 1

3 3
0 1 2
0 0 1
2 0 0
1 1
2
Sample Output 1

Cannot Book Seat

Sample Input 2

2 2
1 0
0 2
0 0
2

Sample Output 2

Cannot Book Seat

Sample Input 3

3 4
0 2 0 1
0 0 0 0
1 0 2 0
1 1
2

Sample Output 3

Seat Booked

-------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        if(mat[r][c] != 0){
            System.out.println("Cannot Book Seat");
            return;
        }
        if(g == 2){
            int[] dr = {0, 0, -1, 1};
            int[] dc = {-1, 1, 0, 0};
            for (int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr>=0 && nc>=0 && nr<n && nc<m) {
                    if (mat[nr][nc] == 1) {
                        System.out.println("Cannot Book Seat");
                        return;
                    }
                }
            }
        }
        System.out.println("Seat Booked");
    }
}
