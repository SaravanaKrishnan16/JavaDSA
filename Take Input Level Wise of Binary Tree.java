Take Input Level Wise of Binary Tree and then print in the inorder preorder post order and level order format

Input Format

-

Constraints

-

Output Format

Inorder traversal of Binary tree

Sample Input 0

1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
  
Sample Output 0

4 2 5 1 6 3 7 
1 2 4 5 3 6 7 
4 5 2 6 7 3 1 
1 2 3 4 5 6 7 

------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

// Node class represents a single node in the Binary Tree
class Node {
    int data;       // Value of the node
    Node left;      // Left child
    Node right;     // Right child

    // Constructor to initialize a node with given value
    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Solution {

    /**
     * Function to build a binary tree level-wise from input array.
     * -1 in the input means no child at that position.
     */
    public static Node buildTree(int[] arr) {
        // If input is empty or root is -1, return null
        if (arr.length == 0 || arr[0] == -1) return null;

        // Create root node
        Node root = new Node(arr[0]);

        // Queue to process nodes level-wise
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1; // index for array traversal
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll(); // take out current node

            // Assign left child
            if (arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            // Ensure index is still within bounds
            if (i >= arr.length) break;

            // Assign right child
            if (arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    /**
     * Recursive Inorder Traversal (Left -> Root -> Right)
     */
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /**
     * Recursive Preorder Traversal (Root -> Left -> Right)
     */
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * Recursive Postorder Traversal (Left -> Right -> Root)
     */
    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * Level Order Traversal (Breadth-First Search using Queue)
     */
    public static void levelorder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();  // take node from queue
            System.out.print(curr.data + " ");

            // Push children into queue
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the entire line of input (space-separated integers)
        String[] input = sc.nextLine().split(" ");

        // Convert string input to integer array
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Build tree from input
        Node root = buildTree(arr);

        // Print traversals
        inorder(root);     // Inorder Traversal
        System.out.println();

        preorder(root);    // Preorder Traversal
        System.out.println();

        postorder(root);   // Postorder Traversal
        System.out.println();

        levelorder(root);  // Level Order Traversal
    }
}
