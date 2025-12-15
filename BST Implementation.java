Implement the BST class which includes following functions -

1.insert - Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
2.delete - Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
3.search - Given an element, find if that is present in BST or not. Return true or false.
4.printTree (recursive) - Print the BST in in the following format -
For printing a node with data N, you need to follow the exact format -

N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.

Input Format

First line number of queries
From Second line start giving queries

Output Format

Results of each query in different line

Sample Input 0

6
1 2
1 3
1 1
4
2 2
4
Sample Output 0

2:L:1,R:3
1:
3:
3:L:1,
1:
Sample Input 1

6
1 2
1 3
1 1
3 2
2 2
3 2
Sample Output 1

true
false

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
    
    static node ins(node root,int d){
        if(root==null)
            return new node(d);
        if(d<=root.data)
            root.left=ins(root.left,d);
        else
            root.right=ins(root.right,d);
        return root;
    }

    static boolean s(node root,int d){
        if(root==null)
            return false;
        if(d==root.data)
            return true;
        if(d<root.data)
            return s(root.left,d);
        else
            return s(root.right,d);
    }
    
    static void dis(node root){
        if(root==null)
            return;
        System.out.print(root.data+":");
        if(root.left!=null)
            System.out.print("L:"+root.left.data+",");
        if(root.right!=null)
            System.out.print("R:"+root.right.data);
        System.out.println();
        dis(root.left);
        dis(root.right);
    }
    
    static node del(node root,int d){
        if(root==null)
            return null;
        if(d<root.data){
            root.left=del(root.left,d);
        }
        else if(d>root.data){
            root.right=del(root.right,d);
        }
        else{
            if(root.left==null && root.right==null)
                return null;
            else if(root.left!=null && root.right==null)
                return root.left;
            else if(root.left==null && root.right!=null)
                return root.right;
            else{
                node t=root.right;
                while(t.left!=null){
                    t=t.left;
                }
                root.data=t.data;
                root.right=del(root.right,t.data);
                return root;
            }
        }
        return root;
    }
    public static void main(String[] args) {
             Scanner sc= new Scanner(System.in);
             node root= null;
             int op=sc.nextInt();
             for(int i=0;i<op;i++){
                 int ch=sc.nextInt();
                 if(ch==1){
                     int d= sc.nextInt();
                     root=ins(root,d);
                  }
                 else if(ch==2){
                      int d=sc.nextInt();
                      del(root,d);
                  }
                 else if(ch==3){
                      int d= sc.nextInt();
                      System.out.println(s(root,d));
                  }   
                  else if(ch==4){
                       dis(root);
                  }
             }
        }
    }

