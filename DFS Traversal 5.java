Given an undirected and disconnected graph G(V, E), print its DFS traversal.

Note:
Here you need to consider that you need to print DFS path starting from vertex 0 only.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Take graph input in the adjacency matrix.
Handle for Disconnected Graphs as well

Input Format

The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.

Constraints

0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second

Output Format

Print the DFS Traversal, as described in the task.

Sample Input 0

4 4
0 1
0 3
1 2
2 3

Sample Output 0

0 1 2 3

-------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    static void dfs(int[][] adj, boolean[] visited, int v, int curr) {
        visited[curr] = true;
        System.out.print(curr+" ");
        for(int i=0;i<v;i++){
            if (adj[curr][i]==1 && !visited[i]){
                dfs(adj,visited,v,i);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adj = new int[V][V];
        for(int i=0;i<E;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        boolean[] visited = new boolean[V];
        if (V>0){
            dfs(adj,visited,V,0);
        }
    }
}
