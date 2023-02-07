package Stack;

import java.util.Stack;

public class StackQuestion2 {

  // Reverse a String using Stack

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "Joey Tribbiani";
        for(char ch : s.toCharArray()){
            stack.push(ch);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
