//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends

class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(char c: s.toCharArray()){
            if(c == '*'){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.add(n1*n2);
            }
            else if(c == '+'){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.add(n1+n2);
            }
            else if(c == '-'){
                int n1 = stack.pop();
                int n2 = stack.pop();
                // System.out.println(n1 + "-"+n2);
                stack.add(n2-n1);
            }
            else if(c == '/'){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.add(n2/n1);
            }else{
                stack.add(Integer.parseInt(""+c));
            }
        }
        return stack.pop();
        // Your code here
    }
}