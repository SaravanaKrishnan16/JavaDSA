Michael has a beautiful house. There is only one staircase to reach his bedroom. He used to climb either 1 stair or 2 stairs at a time. If we consider all possible combinations of climbing, in how many ways can Michael reach to the top?

Input Format

An Integer P denotes the number of stairs in the staircase. If the number of stairs beyond 20, the output should print "Wrong Infrastructure".

Constraints

1<=P<=20

Output Format

The number of ways Michael can climb the staircase to reach to the top

Sample Input 0

5

Sample Output 0

8

Explanation 0

Sample 1: P=5 is the number of stairs in the staircase, the possible way to reach on top would be 8. i.e. 1,1,1,1,1 and 2,2,1.

Sample Input 1

22

Sample Output 1

Wrong Infrastructure

Sample Input 2

8

Sample Output 2

12

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        if (p>20) {
            System.out.print("Wrong Infrastructure");
            return;
        }
        int res = p+(p+1)/2;
        System.out.print(res);
    }
}
