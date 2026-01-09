Given an array of integers, find the number of distinct sums you can get by adding any two elements. Use Set to store unique sums.

Input Format

First line: space-separated integers

Constraints

NA

Output Format

Print the number of distinct sums

Sample Input 0

1 2 3 4

Sample Output 0

5

Explanation 0

All possible pairs and sums:

1+2=3, 1+3=4, 1+4=5

2+3=5, 2+4=6

3+4=7

Distinct sums → {3,4,5,6,7} → 5 sums

----------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         String s = sc.nextLine();
         String[] parts = s.split(" ");
        int n = parts.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                set.add(arr[i]+arr[j]);
            }
        }
        System.out.println(set.size());
    }
}
