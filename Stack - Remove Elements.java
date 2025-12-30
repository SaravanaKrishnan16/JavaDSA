An event management company has come up with a unique idea of printing their event tickets. Based on the ticket number combination (str1), the visitor is directed towards a particular class of audience. The task is to create a program/application to fetch the ticket number based on the following conditions:

Any occurrences of digits EF and G should be deleted. The characters EF should be in the same format.

Input Format

Input consists of String

Constraints

NA

Output Format

Refer the sample output.

Sample Input 0

4523EF58G
  
Sample Output 0

452358
  
Sample Input 1

E12F35G58
  
Sample Output 1

E12F3558 
  
Sample Input 2

EGFE
  
Sample Output 2

E

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty()&&st.peek()=='E'&&ch=='F'){
                st.pop();
            }
            else if(ch!='G'){
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }
        System.out.print(sb.toString());
    }
}
