An array of size N. Which has the following specifications: Each element in the array contains either a policeman or a thief. Each policeman can catch only one thief. A policeman cannot catch a thief who is more than K units away from him. We need to find the maximum number of thieves that can be caught.

Input Format

6
P
T
P
T
T
P
3

Output Format

Maximum thieves caught: 3

Sample Input 0

6
P
T
P
T
T
P
3
Sample Output 0

Maximum thieves caught: 3

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of elements
        int n = sc.nextInt();
        char[] arr = new char[n];

        // Read array elements (P or T)
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        // Read distance constraint (K)
        int k = sc.nextInt();

        // Queues to store indices of policemen and thieves
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thief = new LinkedList<>();

        // Separate policemen and thieves with their positions
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else {
                thief.add(i);
            }
        }

        int count = 0; // Maximum thieves caught

        // Process queues until one becomes empty
        while (!police.isEmpty() && !thief.isEmpty()) {
            int policeIdx = police.peek();
            int thiefIdx = thief.peek();

            // If policeman can catch this thief
            if (Math.abs(policeIdx - thiefIdx) <= k) {
                count++;
                police.poll(); // remove this policeman
                thief.poll();  // remove this thief
            }
            // If policeman is too far left, move to next policeman
            else if (policeIdx < thiefIdx) {
                police.poll();
            }
            // If thief is too far left, move to next thief
            else {
                thief.poll();
            }
        }

        // Print result
        System.out.print("Maximum thieves caught: " + count);
    }
}
