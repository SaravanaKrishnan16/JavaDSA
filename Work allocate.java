Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

Input Format

a 4 20

b 1 10

c 1 40

d 1 30

Output Format

c a

Sample Input 0

a 2 100
b 1 19
c 2 27
d 1 25
e 3 15
  
Sample Output 0

c a e

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

// Class to represent a Job with ID, deadline, and profit
class Job {
    String id;
    int deadline;
    int profit;

    Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Job> jobs = new ArrayList<>();

        // Read jobs until input ends (job ID, deadline, profit)
        while (sc.hasNext()) {
            String id = sc.next();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new Job(id, deadline, profit));
        }

        // Step 1: Sort jobs in descending order of profit (greedy choice)
        jobs.sort((a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline among all jobs
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Create schedule array to store jobs by their scheduled slot
        // Using 1-based indexing for simplicity
        String[] schedule = new String[maxDeadline + 1];

        // Step 4: Assign jobs to the latest available slot before deadline
        for (Job job : jobs) {
            for (int t = job.deadline; t > 0; t--) {
                if (schedule[t] == null) { // Slot is free
                    schedule[t] = job.id;
                    break; // Move to next job
                }
            }
        }

        // Step 5: Print scheduled job IDs in order of slots
        for (int i = 1; i <= maxDeadline; i++) {
            if (schedule[i] != null) {
                System.out.print(schedule[i] + " ");
            }
        }
    }
}
