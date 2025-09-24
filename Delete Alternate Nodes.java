Given a Singly Linked List of integers, delete all the alternate nodes in the list. Example: List: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null Alternate nodes will be: 20, 40, and 60. Hence after deleting, the list will be: Output: 10 -> 30 -> 50 -> null

Input Format

The first and the only line of input will contain the elements of the Singly Linked List separated by a single space and terminated by -1.

Constraints

1 <= N <= 10 ^ 6. Where N is the size of the Singly Linked List Time Limit: 1 sec

Output Format

The only line of output will contain the updated list elements.

Sample Input 0

10 20 30 40 50 60 70 -1
  
Sample Output 0

10 30 50 70 

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

// Class representing a node in the singly linked list
class node {
    int data;    // Data of the node
    node next;   // Pointer to the next node

    node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {

    static node head = null; // Head of the linked list
    static node last = null; // Pointer to the last node

    // Function to insert a new node at the end
    static void ins(int d) {
        node nn = new node(d); // Create new node
        if (head == null) {
            // If list is empty, new node becomes head and last
            head = nn;
            last = nn;
        } else {
            // Append at the end
            last.next = nn;
            last = nn;
        }
    }

    // Function to delete alternate nodes from the linked list
    static void del() {
        node temp = head;
        // Traverse list and skip every alternate node
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next; // Remove next node
            temp = temp.next;           // Move to the next valid node
        }
    }

    // Function to display all elements of the linked list
    static void dis() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read integers until -1 is encountered
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n != -1) {
                ins(n); // Insert into linked list
            } else {
                break; // Stop reading input
            }
        }

        // Delete alternate nodes
        del();

        // Display updated linked list
        dis();
    }
}
