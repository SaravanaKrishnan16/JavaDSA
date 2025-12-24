Praveen is planning a trip and wants to explore different flight routes to reach his destination. He has access to a database of flight connections between various cities. To help him plan his journey efficiently, you need to implement a program that performs Depth First Traversal (DFS) on the flight network graph. Write a program that takes flight information as input and performs a DFS traversal on the flight network graph starting from a given city.

Input Format

The first line consists of two integers separated by a space: V, representing the number of cities in the flight network, and E, representing the number of flight connections. The following E lines consist of the flight connections between cities, represented as pairs of integers v and w, where v is the source city and w is the destination city. The last line of input consists of the starting city for DFS traversal, denoted by startVertex.

Constraints

The test cases will fall under the following constraints: 2 ≤ V ≤ 10 0 ≤ E ≤ V*(V-1)/2 0 ≤ v, w < V 0 ≤ startVertex < V

Output Format

The output displays a message in the format "Depth First Traversal starting from vertex [startVertex]:", where [startVertex] is the integer representing the initial city. Following that next line, it should list the visited cities in DFS traversal order, separated by spaces.

Sample Input 0

4 6
0 1
0 2
1 2
2 0
2 3
3 0
1

Sample Output 0

Depth First Traversal starting from vertex 1:
1 2 0 3        

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void dfs(int i){
        visited[i] = true;
        System.out.print(i+" ");
        for(int x : adj[i]){
            if (!visited[x]){
                dfs(x);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        adj = new ArrayList[V];
        visited = new boolean[V];
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
        }
        int start = sc.nextInt();
        System.out.println("Depth First Traversal starting from vertex "+start+":");
        dfs(start);
    }
}
