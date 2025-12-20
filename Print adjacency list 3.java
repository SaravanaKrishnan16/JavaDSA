Given the number of edges 'E' and vertices 'V' of a bidirectional graph.
Your task is to build a graph through the adjacency list and print the adjacency list for each vertex.image

Input Format

The first line of input is T denoting the number of test cases. Then the first line of each test case contains two positive integers V and E. Where 'V' is the number of vertexes and 'E' is the number of edges in a graph. Next, the 'E' line contains two positive numbers showing that there is an edge between this two vertex.

Constraints

1 <= T <= 200

1 <= V <= 103

1 <= E <= V*(V-1)

Output Format

For each vertex, print their connected nodes in the order you are pushing them inside the list. See the given example.

Sample Input 0

2
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
3 3
0 1
1 2
2 0

Sample Output 0

0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
0-> 1-> 2
1-> 0-> 2
2-> 1-> 0

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt(); 
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++) {
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<E;i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); 
            }
            for(int i=0;i<V;i++){
              System.out.print(i+"-> ");
              ArrayList<Integer> lis = adj.get(i);
              for(int j=0;j<lis.size();j++) {
              if (j == lis.size()-1){
                 System.out.print(lis.get(j));  
              } 
              else {
                 System.out.print(lis.get(j)+"-> ");
              }
            }
            System.out.println();
          }
        }
    }
}
