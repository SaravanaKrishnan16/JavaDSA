Write a program to print the all n digit number which is same after rotate 180 degree .

For Example: If N = 2, all the strobogrammatic numbers of length = 2 are “11”, “88”, “69”, “96”.

Input Format

input consist of a single integer 2

Output Format

11 69 88 96

Sample Input 0

2
  
Sample Output 0

11 69 88 96

----------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Read the number of digits
        int n = sc.nextInt();

        // Calculate the range of n-digit numbers
        // s = smallest n-digit number, e = first number with (n+1) digits
        int s = (int) Math.pow(10, n - 1);
        int e = (int) Math.pow(10, n);

        // Iterate through all n-digit numbers
        for (int i = s; i < e; i++) {
            String num = Integer.toString(i);

            // Check if the number is strobogrammatic
            if (valid(num)) {
                System.out.print(num + " ");
            }
        }
    }

    // Function to check if a number is strobogrammatic
    public static boolean valid(String str) {
        // Set of digits that cannot appear in a strobogrammatic number
        Set<Character> set = new HashSet<>();
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('7');

        StringBuilder sb = new StringBuilder();

        // Construct the 180-degree rotated version of the number
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false; // Not strobogrammatic
            } else if (ch == '6') {
                sb.append('9'); // 6 becomes 9
            } else if (ch == '9') {
                sb.append('6'); // 9 becomes 6
            } else {
                sb.append(ch); // 0,1,8 remain the same
            }
        }

        // Reverse and compare with original number
        return str.equals(sb.reverse().toString());
    }
}
