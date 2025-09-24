Given the arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits. We are given two arrays that represent the arrival and departure times of trains that stop.

Input Format

size of the array first array is arrival time elements second array is departure times elements

Constraints

Constraints: 1 ≤ n ≤ 50000
0000 ≤ A[i] ≤ D[i] ≤ 2359

Expected Time Complexity: O(nLogn) Expected Auxiliary Space: O(1)

Output Format

print the minimum platforms

Sample Input 0

6
900 940 950 1100 1500 1800
910 1200 1120 1130 1900 2000
  
Sample Output 0

3
  
Explanation 0

Minimum 3 platforms are required to safely arrive and depart all trains.

Sample Input 1

3
900 1100 1235
1000 1200 1240
Sample Output 1

1

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of trains
        int n = sc.nextInt();

        // Arrays to store arrival and departure times
        int[] arrival = new int[n];
        int[] departure = new int[n];

        // Read arrival times
        for (int i = 0; i < n; i++) {
            arrival[i] = sc.nextInt();
        }

        // Read departure times
        for (int i = 0; i < n; i++) {
            departure[i] = sc.nextInt();
        }

        // Sort both arrays to process events in order
        Arrays.sort(arrival);
        Arrays.sort(departure);

        // 'platform' tracks current platforms needed
        // 'max' stores the maximum platforms required at any time
        int max = 0, platform = 1;

        // Pointers for arrival and departure arrays
        int i = 1, j = 0;

        // Process until all trains are considered
        while (i < n && j < n) {
            // Case 1: Next train arrives before the earliest train departs
            if (arrival[i] <= departure[j]) {
                platform++;  // Need an extra platform
                i++;         // Move to next arrival
            } 
            // Case 2: A train departs before the next arrival
            else {
                platform--;  // One platform is freed
                j++;         // Move to next departure
            }

            // Update the maximum platforms required
            max = Math.max(max, platform);
        }

        // Print the final result
        System.out.print(max);
    }
}

