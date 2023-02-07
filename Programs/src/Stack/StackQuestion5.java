package Stack;
import java.util.Stack;

// Minimum Cost to make a String valid - Important
public class StackQuestion5 {
    Stack<Character> stack = new Stack<>();
    Integer solve(String s){
        if(s.length()%2 != 0){
            return -1;
        }
        int openingCharacter = 0;
        int closingCharacter = 0;
        for(char ch : s.toCharArray()){
            if('{' == ch){
               stack.push(ch);
                ++openingCharacter;
            }
            else if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                    --openingCharacter;
                }
                else
                    ++closingCharacter;

        }

        return (openingCharacter + 1)/2 + (closingCharacter+1)/2;

    }
    public static void main(String[] args) {
        StackQuestion5 st = new StackQuestion5();
        String str = "{{}}}}}{{{{}";
        Integer ans = st.solve(str);
        System.out.println("Minimum oprations required to  be reversed are " + ans );

    }
}
