You are given a list of N numbers. The task is to find and print the element whose frequency is greater than or equal to N/2 in the list. If no such element exists, print -1.

Input Format

The first line of the input consists of an integer num, representing the size of the list (N). The second line of the input consists of N space-separated integers representing the values of the list.

Constraints

NA

Output Format

Print the element whose frequency is greater than or equal to N/2. If no such element exists, print -1.

Sample Input 0

7  
3 3 4 2 3 3 5

Sample Output 0

3

Explanation 0

The frequency of 3 is 4. Since 4 ≥ 7/2, the output is 3.

Sample Input 1

6  
1 2 3 4 5 6

Sample Output 1

-1

Explanation 1

No element has frequency ≥ 6/2 = 3. Hence the output is -1.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int count = 0,candidate = 0;
        for(int num : arr){
            if(count==0){
                candidate = num;
                count++;
            }
            else if(candidate==num){
                count++;
            }
            else{
                count--;
            }
        }
        count = 0;
        for(int num : arr){
            if(num==candidate){
                count++;
            }
        }
        if(count>n/2){
            System.out.print(candidate);
        }
        else{
            System.out.print("-1");
        }
    }
}
