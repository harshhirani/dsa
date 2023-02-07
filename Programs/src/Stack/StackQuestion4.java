package Stack;

import java.util.Stack;

// Insert an element at its bottom in given stack
// Reverse Stack using recursion
// Sort Stack using recursion
public class StackQuestion4 {
    Stack<Integer> stack = new Stack<>();
    void insertElementAtBottom(Integer element){
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertElementAtBottom(element);
        stack.push(top);
    }

    void reverseStack(){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverseStack();
        insertElementAtBottom(top);

    }

    void inertSorted(int element){
      if( stack.isEmpty()|| stack.peek()<element ){
          stack.push(element);
          return;
      }
      int top = stack.pop();
      inertSorted(element);
      stack.push(top);
    }

    void sortStack(){
        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();
        sortStack();
        inertSorted(top);

    }
    public static void main(String[] args) {
        StackQuestion4 st = new StackQuestion4();
        st.stack.push(20);
        st.stack.push(30);
        st.insertElementAtBottom(10);
        System.out.println("Stack After Insert " + st.stack);
        st.reverseStack();
        System.out.println("Stack after reversal " + st.stack);
        st.stack.push(25);
        st.stack.push(15);
        st.stack.push(20);
        st.stack.push(-30);
        st.stack.push(0);
        st.stack.push(30);
        st.sortStack();
        System.out.println("Stack after sorting " + st.stack);
    }
}
