Naveen is interested in graph theory and wants to determine if there exists a valid path from a given starting vertex to an ending vertex in a graph. He decided to use Depth-First Search (DFS) to solve this problem. Given a graph with vertices and edges, your task is to help Parthi write a program that determines if there is a valid path from a specified starting vertex to an ending vertex. A valid path is a sequence of vertices such that there is an edge between consecutive vertices in the sequence.

Input Format

The first line of input consists of the two integers n and m, representing the number of vertices and edges in the graph, respectively, separated by a space. The next m lines consist of two integers u and v, representing an undirected edge between vertices u and v. The last two lines of input consist of the two integers start and end, representing the starting and ending vertices, respectively.

Constraints

The test cases will fall under the following constraints: 1 ≤ n ≤ 10, 0 ≤ m ≤ n*(n-1)/2 1 ≤ u, v ≤ n, u ≠ v 1 ≤ start, end ≤ n, start ≠ end

Output Format

The output consists of the following format: If there is a valid path from the starting vertex to the ending vertex, print: "There is a path from [start] to [end]". If there is no valid path from the starting vertex to the ending vertex, print: "There is no path from [start] to [end]". Refer to the sample output for the formatting specifications

Sample Input 0

5 4
0 1
1 2
2 3
3 4
0
5

Sample Output 0

There is no path from 0 to 5

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt(); 
        adj = new ArrayList<>();
        for (int i=0;i<=V;i++){ 
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<E;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        visited = new boolean[E+1];
        dfs(start,end);
        if(found){
            System.out.println("There is a path from "+start+" to "+end);
        } 
        else {
            System.out.println("There is no path from "+start+" to "+end);
        }
    }
    static void dfs(int curr,int end){
        if (curr == end){
            found = true;
            return;
        }
        visited[curr] = true;
        for (int i : adj.get(curr)) {
            if (!visited[i]) {
                dfs(i,end);
            }
        }
    }
}
