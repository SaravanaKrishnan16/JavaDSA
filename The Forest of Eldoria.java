In the mystical land of Eldoria, there exists an ancient forest known as the Forest of Eldoria. The forest is said to be shaped like a grand tree where each node represents a guardian spirit protecting a part of the forest. The forest starts from the Great Elder Spirit, and branches out to other guardian spirits, forming a hierarchical structure resembling a binary tree.

The Forest Council wants to send help only to the guardians at the farthest ends of the forest — those with no further guardians under them, known as the leaf guardians. These guardians are responsible for guarding the edges of the forest where danger lurks.

Your task is to help the council identify these leaf guardians.

Input Format

The forest is described by a single line containing the node data of each guardian, separated by spaces.

The guardians are arranged in level order traversal of the binary tree.

A special value null is used internally to represent missing connections but it will not appear in the input.

Constraints

1 ≤ N ≤ 10⁶ Where N is the total number of guardians (nodes) in the forest.

Output Format

Print all the leaf guardians’ data, separated by spaces, in the order they appear in level traversal.

Sample Input 0
1 2 3 4 5 6 7 null null null null null null null null

Sample Output 0
4 5 6 7

Explanation 0
    1
  /   \
 2     3
/ \   / \
4  5 6   7

Here, the leaf guardians are 4, 5, 6, and 7 because they do not have any sub-guardians under them.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

class node {
    int data;
    node left, right;
    node(int d) {
        data = d;
        left = right = null;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<node> q = new LinkedList<>();
        String rootVal = sc.next();
        if (rootVal.equals("null")) return;
        node root = new node(Integer.parseInt(rootVal));
        q.add(root);
        while (!q.isEmpty() && sc.hasNext()) {
            node t = q.poll();
            if (sc.hasNext()) {
                String a = sc.next();
                if (!a.equals("null")) {
                    node nn = new node(Integer.parseInt(a));
                    t.left = nn;
                    q.add(nn);
                }
            }
            if (sc.hasNext()) {
                String b = sc.next();
                if (!b.equals("null")) {
                    node nn = new node(Integer.parseInt(b));
                    t.right = nn;
                    q.add(nn);
                }
            }
        }
        printLeaves(root);
    }

    static void printLeaves(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            node curr = q.poll();
            if (curr.left == null && curr.right == null) {
                System.out.print(curr.data + " ");
            }
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
}
