You are developing a task tracker for a project where tasks are assigned unique IDs. These tasks are arranged in a linked list, based on the order in which they need to be completed. Sometimes, a new task needs to be inserted at a specific position in the list, ensuring it is prioritized correctly. Your task is to write a program to insert a new task at a given position in the task list and print the updated list after the insertion.

Write a program that inserts a new task (represented by a unique task ID) at a specific position in the task list. After the insertion, print the updated list of task IDs. If the entered position value is out the range, print the message as “Position out of range”.

Input Format

The first line contains an integer N, the number of task IDs initially added to the linked list. The second line contains N space-separated integers representing the task IDs. The third line contains an integer P, the position at which the new task ID should be inserted (1-based index). The fourth line contains an integer M, the new task ID to be inserted.

Constraints

The value of P will always be between 1 and N+1 (both inclusive).

Output Format

Print the updated task list with the elements separated by a space.

Sample Input 0

101 102 103 104
2
999
  
Sample Output 0

101 999 102 103 104
Explanation 0

The task list is initialized with 4 task IDs: 101 102 103 104. The new task ID 999 is inserted at position 2 (between 101 and 102). The updated list after insertion is 101 999 102 103 104.

  ------------------------------------------------------------------------------------------------------------------  ------------------------------------------------------------------------------------------------------------------  ------------------------------------------------------------------------------------------------------------------  -----------------------------------------------------------------------------------------

  import java.io.*;
import java.util.*;

// Node class representing each task in the linked list
class node {
    int data;       // Task ID
    node next;      // Pointer to the next node in the list

    node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {

    static node head = null; // Head of the linked list
    static node last = null; // Last node of the linked list

    // Function to insert a node at the end of the linked list
    public static void ins(int d) {
        node nn = new node(d); // Create new node with task ID
        if (head == null) {    // If list is empty, new node becomes head and last
            head = nn;
            last = nn;
        } else {               // Otherwise, add new node at the end
            last.next = nn;
            last = nn;
        }
    }

    // Function to insert a node at a specific position (1-based index)
    public static void insAt(int pos, int d) {
        node nn = new node(d);

        if (pos < 1) return; // Invalid position, do nothing

        if (pos == 1) {      // Insert at the head
            nn.next = head;
            head = nn;
            if (last == null) last = nn; // If list was empty
            return;
        }

        node temp = head;
        int count = 1;

        // Traverse to the node just before desired position
        while (temp != null && count < pos - 1) {
            count++;
            temp = temp.next;
        }

        if (temp == null) return; // Position out of range

        // Insert new node at the position
        nn.next = temp.next;
        temp.next = nn;

        // Update last if inserted at the end
        if (nn.next == null) last = nn;
    }

    // Function to display the linked list
    public static void dis() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); // Print task ID
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read initial tasks as a single line and insert into the linked list
        String[] num = sc.nextLine().split(" ");
        for (String t : num) {
            int n = Integer.parseInt(t);
            ins(n);
        }

        // Read position P and new task ID M
        int p = sc.nextInt();
        int v = sc.nextInt();

        // Insert new task at the specified position
        insAt(p, v);

        // Display the updated task list
        dis();
    }
}
