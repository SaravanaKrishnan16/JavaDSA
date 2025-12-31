Given a postfix (Reverse Polish Notation) expression consisting of operands and operators, determine whether the expression is valid.

A postfix expression is considered valid if:

Every operator has the required number of operands available.

After complete evaluation, exactly one operand remains.

The expression contains only valid operands and operators.

Assume:

Operands are single lowercase letters (a–z) or digits (0–9)

Operators are + , - , * , /

Input Format

A single string S representing a postfix expression.

Constraints

1 ≤ |S| ≤ 100

Expression contains only:

Operands: a–z, 0–9

Operators: + - * /

No whitespace in the expression

Output Format

Valid or Invalid

Sample Input 0

ab+
  
Sample Output 0

Valid
  
Sample Input 1

ab+c*
  
Sample Output 1

Valid
  
Sample Input 2

ab++
  
Sample Output 2

Invalid

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        boolean valid = true;
        for (char ch : s.toCharArray()){
            if(Character.isLowerCase(ch) || Character.isDigit(ch)){
                st.push(ch);
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if (st.size() < 2) {
                    valid = false;
                    break;
                }
                st.pop();
                st.pop();
                st.push('x');
            }
            else {
                valid = false;
                break;
            }
        }
        if (valid && st.size() == 1) {
            System.out.print("Valid");
        } 
        else {
            System.out.print("Invalid");
        }
    }
}
