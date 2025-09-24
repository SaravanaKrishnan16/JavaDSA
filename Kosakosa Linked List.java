Write a program to create linked list by appending the elements without its duplicate and print the resultant linked list and also the mid element of the linked list.

Input Format

Input consists of a single line of elements that belongs to the linked list.

Output Format

Output should be formatted in 2 lines : First line should be the linked list Second line should be the mid element of the linked list.

Sample Input 0

1 2 3 4
  
Sample Output 0

1 2 3 4
3

Sample Input 1

1 2 3 4 5
  
Sample Output 1

1 2 3 4 5
3

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

    // Function to insert a new node at the end (no duplicates allowed)
    static void ins(int d) {
        node nn = new node(d); // Create a new node
        if (head == null) {
            // If list is empty, new node becomes head and last
            head = nn;
            last = nn;
        } else {
            // Check for duplicates
            node temp = head;
            while (temp != null) {
                if (temp.data == d) // Duplicate found, do not insert
                    return;
                temp = temp.next;
            }
            // Insert at the end
            last.next = nn;
            last = nn;
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

    // Function to find and return the middle element of the linked list
    static int mid() {
        node slow = head; // Moves one step at a time
        node fast = head; // Moves two steps at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data; // slow points to the middle node
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read integers until EOF or input ends
        while (sc.hasNext()) {
            int a = sc.nextInt();
            ins(a); // Insert into linked list
        }

        // Display all elements
        dis();
        System.out.println();

        // Print the middle element
        System.out.print(mid());
    }
}
