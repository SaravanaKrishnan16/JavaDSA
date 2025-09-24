Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

Input Format

4
4 20
1 10
1 40
1 30

Output Format

60

Sample Input 0

4
4 20   
1 10
1 40  
1 30
  
Sample Output 0

60

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

// Class to represent a Job with deadline and profit
class Job {
    int deadline, profit;

    Job(int d, int p) {
        deadline = d;
        profit = p;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of jobs
        int n = sc.nextInt();

        // Array of jobs
        Job[] jobs = new Job[n];

        // Read jobs (deadline, profit)
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int p = sc.nextInt();
            jobs[i] = new Job(d, p);
        }

        // Step 1: Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find maximum deadline among all jobs
        int max = 0;
        for (Job job : jobs) {
            max = Math.max(max, job.deadline);
        }

        // Step 3: Create a slot array to keep track of job scheduling
        // -1 means the slot is empty
        int[] slot = new int[max + 1];
        Arrays.fill(slot, -1);

        int totalProfit = 0;

        // Step 4: Place jobs in slots greedily
        for (Job job : jobs) {
            // Try to schedule this job in the latest available slot before its deadline
            for (int t = job.deadline; t > 0; t--) {
                if (slot[t] == -1) {  // If the slot is free
                    slot[t] = job.profit;  // Assign this job's profit
                    totalProfit += job.profit; // Add profit
                    break; // Move to next job
                }
            }
        }

        // Step 5: Print total profit earned
        System.out.print(totalProfit);
    }
}
