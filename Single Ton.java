For a given Binary Tree of type integer, print all the nodes without any siblings.

Input Format

The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.

Constraints

1 <= N <= 10^5 Where N is the total number of nodes in the binary tree. Time Limit: 1 second

Output Format

The only line of output prints the node data in a top to down fashion with reference to the root. Node data in the right subtree will be printed first and then the left subtree. A single space will separate them all.

Sample Input 0
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1

Sample Output 0
9

Sample Input 1
1 2 -1 3 -1 -1 4 -1 7 6 8 -1 -1 9 -1 -1 -1

Sample Output 1
2 3 4 7 9

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

class node{
    int data;
    node left,right;
    node(int d){
        data=d;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<node> q = new LinkedList<>();
        node root = new node(sc.nextInt());
        q.add(root);
        while(!q.isEmpty()){
            node t = q.poll();
            int a = sc.nextInt();
            if(a!=-1){
                node nn = new node(a);
                t.left = nn;
                q.add(nn);
            }
            int b = sc.nextInt();
            if(b!=-1){
                node nn = new node(b);
                t.right=nn;
                q.add(nn);
            }
        }
    find(root);
    }
    static void find(node root){
        if(root==null){
            return ;
        }
       if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        }
        if (root.right != null && root.left == null) {
            System.out.print(root.right.data + " ");
        }
        find(root.right);
        find(root.left);
    }
}
